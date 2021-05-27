package maxDistanceBetweenPairValues;

/**
 * @author: itsuki
 * @create: 2021-05-27 09:59
 **/
public class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int result = 0;
        for (int i = 0; i < nums1.length; i++) {
            int index = binarySearch(nums2, nums1[i]);
            if (index - i >= result) {
                result = index - i;
            }
        }
        return result;
    }

    public int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] < target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        if (nums[left] >= target) return left;
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 2, 2};
        int[] nums2 = new int[]{10, 10, 1};
        System.out.println("answer: " + new Solution().maxDistance(nums1, nums2));
    }
}
