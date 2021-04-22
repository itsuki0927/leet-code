package removeDuplicateLetters;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 解题思路: 单调栈, 遇到一个新字符 如果比栈顶小 并且在新字符后面还有和栈顶一样的 就把栈顶的字符抛弃了
 *
 * @author: itsuki
 * @create: 2021-04-22 08:06
 **/
public class Solution {
    public static String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> deque = new LinkedList();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (deque.contains(aChar)) continue;
            while (!deque.isEmpty() && deque.peekLast() > aChar && s.indexOf(deque.peekLast(), i) != -1) {
                deque.pollLast();
            }
            deque.offerLast(aChar);
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!deque.isEmpty()) {
            stringBuilder.append(deque.pollFirst());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("aaaaa"));
    }
}
