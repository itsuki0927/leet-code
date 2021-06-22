package rob;

/**
 * @author: itsuki
 * @create: 2021-06-22 12:51
 **/
public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0]; // 如果只有一个元素的话, 直接选这一个元素
        dp[1] = Math.max(nums[0], nums[1]); // 如果有两个元素, 选这两个中大的那个
        for (int i = 2; i < nums.length; i++) {
            // Max(前面第一个, 前面第两个 + 当前值)
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().rob(new int[]{1, 2, 3, 1}));
    }
}
