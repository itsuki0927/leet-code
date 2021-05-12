package searchMatrix;

/**
 * 解题思路: 两个二分法找到对应的行与列即可
 *
 * @author: itsuki
 * @create: 2021-05-11 20:51
 **/
public class Solution2 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        int left = 0, right = row - 1;
        // 使用二分查找到第一个大于 target的那一行
        while (left < right) {
            int mid = (left + right) / 2;
            if (matrix[mid][col - 1] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int index = left;

        // 然后在这一行进行二分查找
        left = 0;
        right = col - 1;
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
        int[][] matrix = new int[2][1];
        matrix[0] = new int[]{1};
        matrix[1] = new int[]{3};
//        int[][] matrix = new int[3][4];
//        matrix[0] = new int[]{1, 3, 5, 7};
//        matrix[1] = new int[]{10, 11, 16, 20};
//        matrix[2] = new int[]{23, 30, 34, 60};
        System.out.println(searchMatrix(matrix, 3));
    }
}
