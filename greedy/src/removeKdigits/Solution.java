package removeKdigits;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 解题思路: 利用递增单调队列
 *
 * @author: itsuki
 * @create: 2021-04-21 11:07
 **/
public class Solution {
    public static String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";
        char[] chars = num.toCharArray();
        Deque<Character> queue = new LinkedList<>();
        for (char aChar : chars) {
            // 如果队列不为空 && 队尾大于当前字符 && k > 0
            while (!queue.isEmpty() && queue.peekLast() > aChar && k > 0) {
                // 移除队尾
                queue.pollLast();
                // 去掉一个数字
                k--;
            }
            // 将当前字符添加到队尾
            queue.offerLast(aChar);
        }
        // 如果还有k, 就去除k个队尾的字符
        // 如果字符串一开始就是从小到大排的
        while (k-- > 0) {
            queue.pollLast();
        }
        boolean leadingZero = true;
        // 拼接结果
        StringBuilder stringBuilder = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.pollFirst();
            if (c == '0' && leadingZero) {
                continue;
            }
            leadingZero = false;
            stringBuilder.append(c);
        }
        return stringBuilder.toString().equals("") ? "0" : stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("112", 1));
    }
}
