package numSubarrayProductLessThanK;

/**
 * @author: itsuki
 * @create: 2021-05-31 16:08
 **/
public class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int length = nums.length;
        if (k == 0) return 0;
        int left = 0, right = 0, result = 0, product = 1;

        while (right < length) {
            // 加入窗口
            product *= nums[right];
            // 移动右指针
            right++;

            // left < right
            // [1,1,1] k=1 防止left下标越界
            // 如果乘积>=k, 将最左边元素移除窗口
            while (product >= k && left < right) {
                // 除去最左边的元素
                product /= nums[left];
                // 移动左指针
                left++;
            }

            // 累加结果
            // 因为上面已经移动了右指针, 所以不需要+1了
            result += right - left;
        }

        return result;
    }

    public static void main(String[] args) {
        // System.out.println(new Solution().numSubarrayProductLessThanK(new int[]{10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3}, 19));
        System.out.println(new Solution().numSubarrayProductLessThanK(new int[]{5, 2, 10, 6}, 100));
    }
}
