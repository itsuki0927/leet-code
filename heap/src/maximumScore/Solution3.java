package maximumScore;

import java.util.PriorityQueue;

/**
 * 解题思路: 大根堆 + 贪心
 **/
public class Solution3 {
    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        queue.add(a);
        queue.add(b);
        queue.add(c);
        int count = 0;
        while (true) {
            int maximum = queue.poll();
            int medium = queue.poll();
            if (medium == 0) break;
            queue.add(--maximum);
            queue.add(--medium);
            count++;
        }
        return count;
    }
}
