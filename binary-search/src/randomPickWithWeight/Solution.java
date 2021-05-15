package randomPickWithWeight;

import java.util.Random;

/**
 * 解题思路: 前缀和 + 二分查找
 *
 * @author: itsuki
 * @create: 2021-05-15 09:44
 **/
public class Solution {
    int[] prefix;
    int sum;
    Random random = new Random();

    // 计算前缀和
    Solution(int[] w) {
        int length = w.length;
        prefix = new int[length];
        prefix[0] = w[0];
        for (int i = 1; i < length; i++) {
            prefix[i] = prefix[i - 1] + w[i];
        }
        sum = prefix[length - 1];
    }

    // 根据权重进行二分查找
    public int pickIndex() {
        int target = random.nextInt(sum);
        int left = 1, right = prefix.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (prefix[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
