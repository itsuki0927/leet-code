package rob2;

import java.util.Arrays;

/**
 * @author: itsuki
 * @create: 2021-06-22 15:15
 **/
public class Solution {
    private int answer(int[] nums) {
        int length = nums.length;

        int[] dp = new int[length + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i <= length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }

        return dp[nums.length];
    }

    // 环状排列意味着第一个房子和最后一个房子中只能选择一个偷窃，因此可以把此环状排列房间问题约化为两个单排排列房间子问题
    public int rob2(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        if (length == 1) return nums[0];

        // 选择第一个
        int[] n1 = Arrays.copyOfRange(nums, 0, nums.length - 1);
        // 选择最后一个
        int[] n2 = Arrays.copyOfRange(nums, 1, nums.length);
        return Math.max(answer(n1), answer(n2));
    }

    public static void main(String[] args) {
        System.out.println(new Solution().rob2(new int[]{2, 3, 2}));
    }
}
