package kthSmallest;

/**
 * 解题思路: 对值域进行二分, 然后统计<=mid出现的次数, 如果count < k, 表示范围小了, 即left = mid + 1, 扩大范围, 反之也是如此
 *
 * @author: itsuki
 * @create: 2021-05-13 08:00
 **/
public class Solution {
    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0], right = matrix[n - 1][n - 1];
        while (left < right) {
            // 对值进行二分
            int mid = left + (right - left) / 2;
            // 找出小于mid的个数
            int count = findLessThanOrEqualMid(matrix, n, mid);
            // 如果count < k, 表示范围小了, 所以left + 1扩大查找
            if (count < k) {
                left = mid + 1;
            } else {
                // 范围大了, 缩小查找范围
                right = mid;
            }
        }

        return left;
    }

    private static int findLessThanOrEqualMid(int[][] matrix, int n, int mid) {
        int count = 0, row = 0, col = n - 1;

        //  以列为单位找，找到每一列最后一个<=mid的数即知道每一列有多少个数<=mid
        while (row < n && col >= 0) {
            if (mid >= matrix[row][col]) {
                count += col + 1;
                row++;
            } else {
                col--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] nums = new int[3][3];
        nums[0] = new int[]{1, 5, 9};
        nums[1] = new int[]{10, 11, 13};
        nums[2] = new int[]{12, 13, 15};
        System.out.println(kthSmallest(nums, 8));
    }

}
