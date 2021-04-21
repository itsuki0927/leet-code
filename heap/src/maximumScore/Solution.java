package maximumScore;

import java.util.Arrays;

/**
 * 解题思路: 贪心思想, 每次取最大的两个
 */
public class Solution {
    public static int maximumScore(int a, int b, int c) {
        int[] nums = {a, b, c};
        int count = 0;
        while (true) {
            Arrays.sort(nums);
            if (nums[0] == 0 && nums[1] == 0) break;
            nums[1]--;
            nums[2]--;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(maximumScore(2, 4, 6));
    }
}
