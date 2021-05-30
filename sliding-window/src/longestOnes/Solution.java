package longestOnes;

/**
 * @author: itsuki
 * @create: 2021-05-30 09:17
 **/
public class Solution {
    public int longestOnes(int[] nums, int k) {
        int length = nums.length;
        int left = 0, right = 0;
        int zeroCount = 0;

        while (right < length) {
            // 如果碰到了0, 则记录数量
            if (nums[right] == 0) {
                zeroCount++;
            }
            // 右边界向右移
            right++;

            // 如果[left, right)的0不满足条件时, 缩小窗口
            if (zeroCount > k) {
                // 如果左边界碰到了0, 移除该元素
                if (nums[left] == 0) {
                    zeroCount--;
                }
                // 左边界向右移
                left++;
            }
        }

        return right - left;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
    }
}
