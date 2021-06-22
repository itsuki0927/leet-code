package maxSubArray;

import java.util.Arrays;

/**
 * @author: itsuki
 * @create: 2021-06-22 15:38
 **/
public class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        // 如果 dp[i - 1] > 0，那么可以把 nums[i] 直接接在 dp[i - 1] 表示的那个数组的后面，得到和更大的连续子数组；
        // 如果 dp[i - 1] <= 0，那么 nums[i] 加上前面的数 dp[i - 1] 以后值不会变大。于是 dp[i] 「另起炉灶」，此时单独的一个 nums[i] 的值，就是 dp[i]。
        for (int i = 2; i < nums.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }

        int result = dp[0];
        for (int i = 1; i < dp.length; i++) {
            result = Math.max(result, dp[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
