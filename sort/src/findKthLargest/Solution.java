package findKthLargest;

import java.util.Random;

/**
 * @author: itsuki
 * @create: 2021-06-06 14:30
 **/
public class Solution {
    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    // 传统的partition
    // 固定一个位置，将小于的放左边，大于的放右边
    private int partition(int[] nums, int left, int right) {
        int lt = left;
        int pivot = nums[left];
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                lt++;
                swap(nums, lt, i);
            }
        }
        swap(nums, lt, left);
        return lt;
    }

    public int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        int right = length - 1;
        int left = 0;
        int target = length - k;
        Random random = new Random();

        while (true) {
            int randomIdx = random.nextInt(right - left + 1) + left;
            swap(nums, left, randomIdx);
            int index = partition(nums, left, right);
            if (index == target) {
                return nums[index];
            } else if (index < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
    }
}
