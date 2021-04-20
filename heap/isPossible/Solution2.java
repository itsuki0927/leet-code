package isPossible;

import java.util.HashMap;

/**
 * 运用贪心思想来检验是否分为连续子序列
 **/
public class Solution2 {
    public boolean isPossible2(int[] nums) {
        // 用来计算每个num出现了多少次
        HashMap<Integer, Integer> counts = new HashMap<>();
        // 存储以数字i结尾的且符合题意的连续子序列个数
        HashMap<Integer, Integer> tail = new HashMap<>();
        for (int n : nums) {
            counts.merge(n, 1, Integer::sum);
        }
        for (int n : nums) {
            int c = counts.get(n);
            if (c <= 0) continue;
            else if (tail.getOrDefault(n - 1, 0) > 0) {
                // counts[n]--
                counts.put(n, c - 1);
                // tail[n-1]--
                tail.put(n - 1, tail.get(n - 1) - 1);
                // tail[n]++
                tail.put(n, tail.getOrDefault(n, 0) + 1);
            } else if (counts.getOrDefault(n + 1, 0) > 0 && counts.getOrDefault(n + 2, 0) > 0) {
                // counts[n]--
                counts.put(n, c - 1);
                // counts[n+1]--
                counts.put(n + 1, counts.get(n + 1) - 1);
                // counts[n+2]--
                counts.put(n + 2, counts.get(n + 2) - 1);
                // tail[n+2]++
                tail.put(n + 2, tail.getOrDefault(n + 2, 0) + 1);
            } else {
                return false;
            }
        }
        return true;
    }
}
