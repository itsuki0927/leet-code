package equationsPossible;

/**
 * @author: itsuki
 * @create: 2021-06-08 14:51
 **/
public class Solution {
    public boolean equationsPossible(String[] equations) {
        UnionFind unionFind = new UnionFind();
        for (String equation : equations) {
            char[] chars = equation.toCharArray();
            if (chars[1] == '=') {
                unionFind.union(chars[0] - 'a', chars[3] - 'a');
            }
        }
        for (String equation : equations) {
            char[] chars = equation.toCharArray();
            if (chars[1] == '!') {
                if (unionFind.isConnected(chars[0] - 'a', chars[3] - 'a')) {
                    return false;
                }
            }
        }
        return true;
    }

    static class UnionFind {
        private final int[] parent;

        UnionFind() {
            parent = new int[26];
            for (int i = 0; i < 26; i++) {
                parent[i] = i;
            }
        }

        public int findRoot(int x) {
            while (parent[x] != x) {
                // 路经压缩
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int xRoot = findRoot(x);
            int yRoot = findRoot(y);
            // 如果不在一个集合中进行合并
            if (xRoot != yRoot) {
                parent[xRoot] = yRoot;
            }
        }

        public boolean isConnected(int x, int y) {
            return findRoot(x) == findRoot(y);
        }
    }
}
