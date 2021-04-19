package kClosest;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 解题思路： 使用大根堆
 */
public class Solution {
    public static int getDistanceToOrigin(int[] nums) {
        int n1 = nums[0], n2 = nums[1];
        return (n1 * n1 + n2 * n2);
    }

    public static int[][] kClosest(int[][] points, int k) {
        int[][] ret = new int[k][2];
        PriorityQueue<int[]> queue = new PriorityQueue((Comparator<int[]>) (o1, o2) -> (int) (getDistanceToOrigin(o2) - getDistanceToOrigin(o1)));
        for (int[] point : points) {
            queue.add(point);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        int i = 0;
        while (!queue.isEmpty()) {
            ret[i++] = queue.poll();
        }
        return ret;
    }
}
