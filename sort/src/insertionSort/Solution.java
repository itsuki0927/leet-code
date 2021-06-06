package insertionSort;

import java.util.Arrays;

/**
 * @author: itsuki
 * @create: 2021-06-06 10:08
 **/
public class Solution {
    public void insertionSort(int[] nums) {
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            int temp = nums[i];
            int j = i;
            while (j > 0 && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{6, 5, 4, 73, 1, 3, 2, 0, -6, 7, 6, 55};
        new Solution().insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
