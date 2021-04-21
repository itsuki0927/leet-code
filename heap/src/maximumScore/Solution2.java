package maximumScore;

import java.util.Arrays;

/**
 * 解题思路:
 * 数学
 * 1. a+b<=c, 结果就是a+b
 * 2. a+b>c,  结果就是(a+b+c)/2
 **/
public class Solution2 {
    public static int maximumScore(int a, int b, int c) {
        int[] nums = {a, b, c};
        Arrays.sort(nums);
        if (nums[0] + nums[1] <= nums[2]) return nums[0] + nums[1];
        return (nums[0] + nums[1] + nums[2]) >> 1;
    }
}
