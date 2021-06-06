package quickSort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author: itsuki
 * @create: 2021-06-06 10:24
 **/
public class Solution2 {
    private static final int INSERTION_SORT_THRESHOLD = 7;

    private static final Random RANDOM = new Random();

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        quickSort(nums, 0, len - 1);
        return nums;
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        // if (right - left <= INSERTION_SORT_THRESHOLD) {
        //     insertionSort(nums, left, right);
        //     return;
        // }

        int randomIdx = RANDOM.nextInt(right - left + 1) + left;
        swap(nums, left, randomIdx);

        int index = partition(nums, left, right);
        quickSort(nums, left, index - 1);
        quickSort(nums, index + 1, right);
    }

    public int partition(int[] nums, int left, int right) {

        int pivot = nums[left];
        int lt = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                lt++;
                swap(nums, i, lt);
            }
        }
        swap(nums, lt, left);

        return lt;
    }

    private void swap(int[] nums, int left, int randomIdx) {
        int temp = nums[left];
        nums[left] = nums[randomIdx];
        nums[randomIdx] = temp;
    }

    private void insertionSort(int[] nums, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = nums[i];
            int j = i;
            while (j > left && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{6, 7, 1, 2, 8, 4, 5, 3};
        Solution2 solution = new Solution2();
        solution.sortArray(nums);
        // solution.partition(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
