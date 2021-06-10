package minIncrementForUnique;

import java.util.Arrays;

/**
 * @author: itsuki
 * @create: 2021-06-10 09:40
 **/
public class Solution {
    public int minIncrementForUnique(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return 0;
        int result = 0;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            // 如果当前元素 <= 前一个元素
            if (nums[i] <= nums[i - 1]) {
                // 统计次数
                result += nums[i - 1] - nums[i] + 1;
                // 更新当前元素为 前一个元素+1
                nums[i] = nums[i - 1] + 1;
            }
        }
        return result;
    }
}
