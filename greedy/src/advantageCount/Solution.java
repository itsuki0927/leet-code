package advantageCount;

import java.util.Arrays;

/**
 * 解题思路: 田忌赛马
 *
 * @author: itsuki
 * @create: 2021-05-04 14:53
 **/
public class Solution {
    public static int[] advantageCount(int[] A, int[] B) {
        int length = B.length;
        int[][] sortedB = new int[length][2];
        for (int i = 0; i < length; i++) {
            // 保存值和下标
            sortedB[i] = new int[]{B[i], i};
        }
        // 排序
        Arrays.sort(A);
        Arrays.sort(sortedB, (o1, o2) -> o1[0] - o2[0]);

        int[] ret = new int[length];
        // 当前最小的B马
        int left = 0;
        // 当前最大的B马
        int right = length - 1;
        for (int i = 0; i < length; i++) {
            // 如果当前马比最小的B马小
            if (A[i] <= sortedB[left][0]) {
                // 更新最大的马
                ret[sortedB[right--][1]] = A[i];
            } else {
                ret[sortedB[left++][1]] = A[i];
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(advantageCount(new int[]{12, 24, 8, 32}, new int[]{13, 25, 32, 11})));
    }
}
