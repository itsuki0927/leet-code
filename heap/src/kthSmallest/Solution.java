package kthSmallest;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 解题思路: 利用最小堆, 先将数组中的第0个元素添加到最小堆, 因为最小值肯定在其中,
 * 然后弹出k-1个数,每次弹出时加入弹出数的右边那个数
 */
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue((Comparator<int[]>) (o1, o2) -> o1[0] - o2[0]);
        int length = matrix.length;
        for (int i = 0; i < length; i++) {
            queue.add(new int[]{matrix[i][0], i, 0});
        }
        for (int i = 0; i < k - 1; i++) {
            int[] now = queue.poll();
            if (now[2] != length - 1) {
                queue.add(new int[]{matrix[now[1]][now[2] + 1], now[1], now[2] + 1});
            }
        }

        return queue.poll()[0];
    }
}
