public class Solution {
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int stone : stones) {
            queue.add(stone);
        }
        while (queue.size() > 1) {
            int n1 = queue.poll();
            int n2 = queue.poll();
            if (n1 != n2) {
                queue.add(n1 - n2);
            }
        }

        return queue.isEmpty() ? 0 : queue.poll();
    }
}

