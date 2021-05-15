package singleNonDuplicate;

/**
 * 解题思路: 二分查找
 * <p>
 * 对偶数索引进行二分查找, 判断下一个元素是否与偶数索引的元素相同
 * 1. 如果相同, 说明在mid的右边
 * 2. 如果不相同, 说明在mid的左边
 *
 * @author: itsuki
 * @create: 2021-05-15 08:43
 **/
public class Solution2 {
    public static int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            // 如果是奇数索引, 转换偶数索引
            if (mid % 2 == 1) mid--;
            // 如果与后一个元素相同
            if (nums[mid] == nums[mid + 1]) {
                // 下一个缩小区间是: [mid+2, right]
                left = mid + 2;
            } else {
                // [left, mid]
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int i = singleNonDuplicate(new int[]{1, 1, 2, 3, 3});
        System.out.println(i);
    }
}
