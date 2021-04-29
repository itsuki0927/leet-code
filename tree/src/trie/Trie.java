package trie;

class TrieNode {
    public int pass;
    public int end;
    public TrieNode[] next;

    public TrieNode() {
        this.pass = 0;
        this.end = 0;
        this.next = new TrieNode[26];
    }
}

/**
 * @author: itsuki
 * @create: 2021-04-28 21:01
 **/
public class Trie {
    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word == null) return;
        char[] chars = word.toCharArray();
        TrieNode node = root;
        node.pass++;
        int index;
        for (char c : chars) {
            index = c - 'a';
            if (node.next[index] == null) {
                node.next[index] = new TrieNode();
            }
            node = node.next[index];
            node.pass++;
        }
        node.end++;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (word == null) return false;
        char[] chars = word.toCharArray();
        TrieNode node = root;
        int index;
        for (char c : chars) {
            index = c - 'a';
            if (node.next[index] == null) {
                return false;
            }
            node = node.next[index];
        }
        return node.end >= 1;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public int startsWith(String prefix) {
        if (prefix == null) return 0;
        char[] chars = prefix.toCharArray();
        TrieNode node = root;
        int index;
        for (char c : chars) {
            index = c - 'a';
            if (node.next[index] == null) {
                return 0;
            }
            node = node.next[index];
        }
        return node.pass;
    }

    public void delete(String word) {
        if (search(word)) {
            char[] chars = word.toCharArray();
            TrieNode node = root;
            node.pass--;
            int index;
            for (char c : chars) {
                index = c - 'a';
                if (--node.pass == 0) {
                    node.next[index] = null;
                    return;
                }
                node = node.next[index];
            }
            node.end--;
        }
    }
}