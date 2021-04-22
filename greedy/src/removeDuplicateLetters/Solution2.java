package removeDuplicateLetters;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 解题思路: 单调栈, 使用visit数组保存是否访问过, counts数组统计字符次数
 *
 * @author: itsuki
 * @create: 2021-04-22 08:50
 **/
public class Solution2 {
    public static String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray();
        int[] counts = new int[26];
        boolean[] visit = new boolean[26];
        Deque<Character> deque = new LinkedList();
        // 统计字符次数
        for (char aChar : chars) {
            counts[aChar - 'a']++;
        }
        for (char aChar : chars) {
            counts[aChar - 'a']--;
            int index = aChar - 'a';
            if (visit[index]) continue;
            // 如果字符还有次数 && 队尾 > 当前字符
            while (!deque.isEmpty() && deque.peekLast() > aChar && counts[deque.peekLast() - 'a'] > 0) {
                // 弹出队尾
                // 更新visit
                visit[deque.pollLast() - 'a'] = false;
            }

            deque.offerLast(aChar);
            visit[index] = true;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!deque.isEmpty()) {
            stringBuilder.append(deque.pollFirst());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("cbacdcbc"));
    }
}
