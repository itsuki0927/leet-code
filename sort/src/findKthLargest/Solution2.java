package findKthLargest;

import java.util.Random;

/**
 * @author: itsuki
 * @create: 2021-06-06 14:30
 **/
public class Solution2 {
    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    // 传统的partition
    // 固定一个位置，将小于的放左边，大于的放右边
    private int partition(int[] nums, int left, int right) {
        int lt = left + 1;
        int pivot = nums[left];
        int gt = right;
        while (true) {
            while (lt <= right && nums[lt] < pivot) lt++;
            while (gt > left && nums[gt] > pivot) gt--;

            if (lt >= gt) break;

            swap(nums, lt, gt);
            lt++;
            gt--;
        }
        swap(nums, left, gt);
        return gt;
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
