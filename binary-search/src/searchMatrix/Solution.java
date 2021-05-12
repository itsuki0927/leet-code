package searchMatrix;

/**
 * 解题思路:
 * @author: itsuki
 * @create: 2021-05-11 20:51
 **/
public class Solution {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int index = 0, row = matrix.length, col = matrix[0].length;
        if (target > matrix[row - 1][col - 1]) return false;
        // 先找到一个大于 < target的那一行
        while (matrix[index][col - 1] < target) index++;

        // 然后在这一行进行二分查找
        int left = 0, right = matrix[0].length - 1;
        while (left < right) {
            // 因为数据量不大, left + right 不会溢出
            int mid = (left + right) / 2;
            if (matrix[index][mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // 判断位置与target符合
        return matrix[index][left] == target;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[3][4];
        matrix[0] = new int[]{1, 3, 5, 7};
        matrix[1] = new int[]{10, 11, 16, 20};
        matrix[2] = new int[]{23, 30, 34, 60};
        System.out.println(searchMatrix(matrix, 1));
    }
}
