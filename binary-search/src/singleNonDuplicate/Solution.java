package singleNonDuplicate;

/**
 * 解题思路: 二分查找
 *
 * @author: itsuki
 * @create: 2021-05-15 08:43
 **/
public class Solution {
    public static int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == nums[mid + 1]) { // 如果中点与右边相同
                // [1,1,2,2,mid,mid+1,5,6,6]
                // 如果左边有偶个数字, 表示唯一的元素在右边
                // [mid+2, right]
                if ((mid - left) % 2 == 0) {
                    left = mid + 2;
                } else {
                    // [1,1,2,mid,mid+1,6,6]
                    // 如果有奇个数字, 表示唯一的元素在左边
                    right = mid - 1;
                }
            } else if (nums[mid] == nums[mid - 1]) {// 如果中点与左边相同
                if ((mid - left - 1) % 2 == 0) {
                    left = mid + 1;
                } else {
                    right = mid - 2;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int i = singleNonDuplicate(new int[]{1, 1, 2, 3, 3});
        System.out.println(i);
    }
}
