package minIncrementForUnique;

import java.util.Arrays;

/**
 * @author: itsuki
 * @create: 2021-06-10 09:40
 **/
public class Solution2 {
    public int minIncrementForUnique(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return 0;
        int result = 0;
        Arrays.sort(nums);
        int preNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 如果相等表示已经是最优的数字
            // 然后更新为最优数字
            if (nums[i] == preNum + 1) {
                preNum = nums[i];
            } else if (preNum > nums[i]) {
                preNum = nums[i];
            } else {
                result += (preNum - nums[i] + 1);
                preNum++;
            }
        }
        return result;
    }
}
