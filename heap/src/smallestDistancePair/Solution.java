package smallestDistancePair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * NOTE: 会超时
 * 使用小根堆保存最小值, 然后如果有小于堆顶的元素添加
 */
public class Solution {
    static class Node {
        int l;
        int r;

        public Node(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        PriorityQueue<Node> queue = new PriorityQueue(nums.length, Comparator.<Node>comparingInt(o -> (nums[o.r] - nums[o.l])));
        for (int i = 0; i < nums.length - 1; i++) {
            queue.add(new Node(i, i + 1));
        }
        while (--k > 0) {
            Node node = queue.poll();
            if (node.r + 1 < nums.length) {
                queue.add(new Node(node.l, node.r + 1));
            }
        }
        Node node = queue.poll();
        return nums[node.r] - nums[node.l];
    }
}
