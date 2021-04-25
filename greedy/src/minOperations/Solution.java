package minOperations;

import java.util.Arrays;

/**
 * 解题思路: 后一个比前一个大1保证递增
 *
 * @author: itsuki
 * @create: 2021-04-25 20:54
 **/
public class Solution {
    public static int minOperations(int[] nums) {
        int ret = 0;
        for (int i = 1; i < nums.length; i++) {
            // 如果前一个比后一个大
            if (nums[i - 1] >= nums[i]) {
                // 要累加的值: 就是前一个减去后一个+1
                ret += nums[i - 1] + 1 - nums[i];
                // 后一个变成前一个+1
                nums[i] = nums[i - 1] + 1;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{1, 1, 1}));
    }
}
