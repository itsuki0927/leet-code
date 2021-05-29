package minSubArrayLen;

/**
 * @author: itsuki
 * @create: 2021-05-29 14:07
 **/
public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE, length = nums.length;
        int left = 0, right = 0, sum = 0;

        while (right < length) {
            // 累加和
            sum += nums[right];
            // 指针向右移
            right++;
            // 如果>=target, 缩小窗口大小
            while (sum >= target) {
                // 记录最小的窗口
                result = Math.min(result, right - left + 1);
                // 缩小窗口
                sum -= nums[left];
                left++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
    }
}
