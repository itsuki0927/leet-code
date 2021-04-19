public class Solution {
    public static int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int[] ret = new int[k];
        if (k == 0) return ret;
        for (int n : arr) {
            if (queue.size() < k) {
                queue.add(n);
            } else if (n < queue.peek()) {
                queue.poll();
                queue.add(n);
            }
        }
        for (int i = 0; i < k; i++) {
            ret[i] = queue.poll();
        }
        return ret;
    }
}
