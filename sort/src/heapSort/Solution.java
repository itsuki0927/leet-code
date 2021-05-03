package src.heapSort;

import java.util.Arrays;

/**
 * @author: itsuki
 * @create: 2021-04-29 15:22
 **/
public class Solution {
    private void swap(int[] nums, int m, int n) {
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }

    public void heapInsert(int[] nums, int index) {
        while (nums[index] > nums[(index - 1) / 2]) {
            swap(nums, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public void heapify(int[] nums, int index, int heapSize) {
        int left = index * 2 + 1, largest;
        while (left < heapSize) {
            largest = left + 1 < heapSize && nums[left + 1] > nums[left] ? left + 1 : left;

            largest = nums[largest] > nums[index] ? largest : index;

            if (largest == index) break;
            swap(nums, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public void heapSort(int[] nums) {
        int heapSize = nums.length;
        for (int i = 0; i < heapSize; i++) heapInsert(nums, i);

        swap(nums, 0, --heapSize);
        while (heapSize > 0) {
            heapify(nums, 0, heapSize);
            swap(nums, 0, --heapSize);
        }
    }

    public static void main(String[] args) {
        int[] n = new int[]{5, 4, 6, 2, 3, 5, 6, 4, 4, 3, 1, 10, 40};
        new Solution().heapSort(n);
        System.out.println(Arrays.toString(n));
    }
}
