package intersection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 解题思路: 将一个数组排序, 遍历另外一个数组然后进行二分查找即可
 *
 * @author: itsuki
 * @create: 2021-05-12 10:49
 **/
public class Solution {
    private static boolean binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left] == target;
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        // 排序
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            // 对nums1的每个元素进行二分查找
            if (binarySearch(nums2, num)) {
                set.add(num);
            }
        }

        int index = 0;
        int[] ret = new int[set.size()];
        for (int n : set) {
            ret[index++] = n;
        }
        return ret;
    }
}
