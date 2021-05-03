package quickSort;

import java.util.Arrays;

/**
 * @author: itsuki
 * @create: 2021-04-29 14:49
 **/
public class Solution {
    private void swap(int[] nums, int m, int n) {
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }

    private int[] partition(int[] nums, int l, int r) {
        int less = l - 1, more = r, povit = nums[r];
        while (l < more) {
            if (nums[l] > povit) {
                swap(nums, l, --more);
            } else if (nums[l] < povit) {
                swap(nums, l++, ++less);
            } else {
                l++;
            }
        }
        swap(nums, more, r);
        return new int[]{less + 1, more};
    }

    public void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            swap(nums, (int) (l + Math.floor(Math.random() * (r - l + 1))), r);
            int[] part = partition(nums, l, r);
            quickSort(nums, l, part[0] - 1);
            quickSort(nums, part[1] + 1, r);
        }
    }

    public static void main(String[] args) {
        int[] n = new int[]{5, 4, 6, 2, 3, 5, 6, 4, 4, 3, 1, 10, 40};
        new Solution().quickSort(n, 0, n.length - 1);
        System.out.println(Arrays.toString(n));
    }
}
