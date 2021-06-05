package removeDuplicateLetters;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: itsuki
 * @create: 2021-06-04 15:50
 **/
public class Solution {
    public String removeDuplicateLetters(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        int[] count = new int[26];
        boolean[] visit = new boolean[26];
        // 加入哨兵, 不需要在判断栈是否为空
        deque.offerLast('a');
        // 计算数量
        for (char c : chars) {
            count[c - 'a']++;
        }

        for (char c : chars) {
            int index = c - 'a';
            // 减少数量
            count[index]--;
            // 如果已经在字符里的直接跳过
            if (visit[index]) continue;
            // 栈顶元素比当前元素大 且 这个字符后面还会再次出现
            while (deque.peekLast() > c && count[deque.peekLast() - 'a'] > 0) {
                // 弹出栈顶元素
                char top = deque.pollLast();
                // 将元素标记为未出现过
                visit[top - 'a'] = false;
            }
            deque.offerLast(c);
            // 标记为出现过单调栈
            visit[index] = true;
        }

        // 移除掉哨兵
        deque.pollFirst();
        StringBuilder stringBuilder = new StringBuilder();
        while (!deque.isEmpty()) {
            stringBuilder.append(deque.pollFirst());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicateLetters("cbacdcbc"));
    }
}
