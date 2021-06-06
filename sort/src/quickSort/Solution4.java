package quickSort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author: itsuki
 * @create: 2021-06-06 14:09
 **/
public class Solution4 {
    /**
     * 列表大小等于或小于该大小，将优先于 quickSort 使用插入排序
     */
    private static final int INSERTION_SORT_THRESHOLD = 7;

    private static final Random RANDOM = new Random();

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        quickSort(nums, 0, len - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (right - left <= INSERTION_SORT_THRESHOLD) {
            insertionSort(nums, left, right);
            return;
        }
        if (left >= right) return;
        int randomIdx = RANDOM.nextInt(right - left + 1) + left;
        swap(nums, left, randomIdx);
        int lt = left;
        int pivot = nums[left];
        int gt = right + 1;
        int i = left + 1;
        while (i < gt) {
            if (nums[i] < pivot) {
                swap(nums, ++lt, i++);
            } else if (nums[i] == pivot) {
                i++;
            } else {
                swap(nums, --gt, i);
            }
        }
        swap(nums, left, lt);
        quickSort(nums, left, lt - 1);
        quickSort(nums, gt, right);
    }

    private void swap(int[] nums, int left, int randomIdx) {
        int num = nums[left];
        nums[left] = nums[randomIdx];
        nums[randomIdx] = num;
    }

    private void insertionSort(int[] nums, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
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
        int[] nums = new int[]{6, 7, 1, 2, 2, 3, 8, 4, 5, 3, 3, 3, 3, 3, 3};
        Solution4 solution = new Solution4();
        solution.sortArray(nums);
        // solution.partition(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
