package src.mergeSort;

import java.util.Arrays;

/**
 * @author: itsuki
 * @create: 2021-04-29 14:59
 **/
public class Solution {
    public void merge(int[] nums, int left, int right, int bound) {
        int[] help = new int[bound - left + 1];
        int mid = right - 1, i = left, j = right, k = 0;
        while (i <= mid && j <= bound) {
            if (nums[i] < nums[j]) {
                help[k++] = nums[i++];
            } else {
                help[k++] = nums[j++];
            }
        }

        while (i <= mid) help[k++] = nums[i++];
        while (j <= bound) help[k++] = nums[j++];

        for (int l = 0; l < help.length; l++) {
            nums[left + l] = help[l];
        }
    }

    public void mergeSort(int[] nums, int left, int right) {
        if (left == right) return;
        int mid = left + ((right - left) >> 1);
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid + 1, right);
    }

    public static void main(String[] args) {
        int[] n = new int[]{5, 4, 6, 2, 3, 5, 6, 4, 4, 3, 1, 10, 40};
        new Solution().mergeSort(n, 0, n.length - 1);
        System.out.println(Arrays.toString(n));
    }
}
