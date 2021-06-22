package rob;

/**
 * @author: itsuki
 * @create: 2021-06-22 12:51
 **/
public class Solution2 {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length + 1];
        dp[0] = 0; // k = 0, 表示没有房子
        dp[1] = nums[0]; // k = 1, 表示有一个房子
        for (int i = 2; i <= nums.length; i++) {
            // Max(前面第一个, 前面第两个 + 当前值)
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[nums.length];
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().rob(new int[]{1, 2, 3, 1}));
    }
}
