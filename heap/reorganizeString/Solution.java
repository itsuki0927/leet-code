package reorganizeString;

import java.util.PriorityQueue;

/**
 * 解题思路: 同rearrangeBarcodes, 这里加了一个判断, 如果一个字符数大于数组的一般以上就不能重构
 */
public class Solution {
    public String reorganizeString(String S) {
        int[] counts = new int[26];
        char[] chars = S.toCharArray();
        int maxCount = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (char aChar : chars) {
            counts[aChar - 'a']++;
            maxCount = Math.max(counts[aChar - 'a'], maxCount);
        }
        if (maxCount > (S.length() + 1) / 2) {
            return "";
        }
        PriorityQueue<Character> queue = new PriorityQueue<>((o1, o2) -> counts[o2 - 'a'] - counts[o1 - 'a']);
        for (char c = 'a'; c <= 'z'; c++) {
            if (counts[c - 'a'] != 0) {
                queue.add(c);
            }
        }
        System.out.println(queue);
        while (queue.size() > 1) {
            char c1 = queue.poll();
            char c2 = queue.poll();
            stringBuilder.append(c1).append(c2);
            int index1 = c1 - 'a', index2 = c2 - 'a';
            counts[index1]--;
            counts[index2]--;
            if (counts[index1] > 0) {
                queue.add(c1);
            }
            if (counts[index2] > 0) {
                queue.add(c2);
            }
        }
        while (!queue.isEmpty()) stringBuilder.append(queue.poll());
        return stringBuilder.toString();
    }
}

