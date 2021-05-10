package carPooling;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 解题思路: 根据终点位置构建小根堆, 然后如果遍历整个数组, 弹出到达了终点的元素, 如果能够遍历完成表示能够完成该任务,
 *
 * @author: itsuki
 * @create: 2021-05-06 09:44
 **/
public class Solution {
    public static boolean carPooling(int[][] trips, int capacity) {
        // 按照终点位置构建小根堆
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        // 根据起点位置进行排序
        Arrays.sort(trips, (o1, o2) -> o1[1] - o2[1]);

        for (int[] trip : trips) {
            // 如果终点 <= 当前的起点, 表示到达了该站, 需要下车
            while (!queue.isEmpty() && queue.peek()[2] <= trip[1]) {
                // 弹出
                int[] item = queue.poll();
                // 容量回滚
                capacity += item[0];
            }
            // 减少容量
            capacity -= trip[0];
            // 如果容量不够, 不能到终点
            if (capacity < 0) return false;
            // 添加到小根堆
            queue.offer(trip);
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] ints = new int[4][3];
        ints[0] = new int[]{4, 3, 4};
        ints[1] = new int[]{3, 2, 4};
        ints[2] = new int[]{1, 8, 9};
        ints[3] = new int[]{7, 2, 5};
        System.out.println(carPooling(ints, 14));
    }
}
