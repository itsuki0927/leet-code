package threeSumClosest;

import java.util.Arrays;

/**
 * @author: itsuki
 * @create: 2021-06-02 08:30
 **/
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length, result = nums[0] + nums[1] + nums[2];
        int left, right;

        for (int i = 0; i < length - 2; i++) {
            left = i + 1;
            right = length - 1;
            while (left < right) {
                int sum = nums[left] + nums[i] + nums[right];
                if (Math.abs(target - sum) < Math.abs(target - result)) {
                    result = sum;
                }
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    return target;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().threeSumClosest(new int[]{-3, -2, -5, 3, -4}, -1));
        // System.out.println(new Solution().threeSumClosest(new int[]{-1, 2, 1, -4, 6, 5, 2, -3}, 4));
    }
}
