/**
 * 解题思路: 使用优先队列
 * 1. 一开始将最小的丑数1放入队列
 * 2. 每次从队列中取最小值, 然后将x对应的2x、3x、5x入队
 * 3. 对步骤2重复多次, 第n个出队的就是结果
 **/
public class Solution {
    public static int nthUglyNumber(int n) {
        int[] elements = new int[]{2, 3, 5};
        Set<Long> set = new HashSet<Long>();
        PriorityQueue<Long> queue = new PriorityQueue<>();
        queue.add(1L);
        for (int i = 1; i < n; i++) {
            long current = queue.poll();
            for (int element : elements) {
                long next = current * element;
                if (set.add(next)) {
                    queue.add(next);
                }
            }
        }
        return Math.toIntExact(queue.poll());
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }
}

