package minimumSize;

/**
 * 解题思路: 二分查找
 *
 * @author: itsuki
 * @create: 2021-05-17 20:12
 **/
public class Solution {
    public static int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = Integer.MIN_VALUE;
        for (int num : nums) {
            right = Math.max(num, right);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 如果满足条件, 缩小搜索区间 [left, mid]
            if (check(nums, mid, maxOperations)) {
                right = mid;
            } else {
                // [mid+1, right]
                left = mid + 1;
            }
        }
        return left;
    }

    // 检查mid是否满足条件条件
    private static boolean check(int[] nums, int mid, int maxOperations) {
        int count = 0;
        for (int num : nums) {
            if (num <= mid) continue;
            count += num % mid == 0 ? num / mid - 1 : num / mid;
            if (count > maxOperations) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(minimumSize(new int[]{2, 4, 8, 2}, 4));
    }
}
