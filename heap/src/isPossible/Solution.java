package isPossible;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {
    public boolean isPossible(int[] nums) {
        HashMap<Integer, PriorityQueue<Integer>> hashMap = new HashMap<>();
        for (int n : nums) {
            if (!hashMap.containsKey(n)) {
                hashMap.put(n, new PriorityQueue<>());
            }
            if (hashMap.containsKey(n - 1)) {
                PriorityQueue<Integer> queue = hashMap.get(n - 1);
                int prevLength = queue.poll();
                if (queue.isEmpty()) {
                    hashMap.remove(n - 1);
                }
                hashMap.get(n).add(prevLength + 1);
            } else {
                hashMap.get(n).add(1);
            }
        }
        Set<Map.Entry<Integer, PriorityQueue<Integer>>> entries = hashMap.entrySet();
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : entries) {
            PriorityQueue<Integer> value = entry.getValue();
            if (value.peek() < 3) return false;
        }
        return true;
    }

    public boolean isPossible2(int[] nums) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        HashMap<Integer, Integer> tail = new HashMap<>();
        for (int n : nums) {
            counts.merge(n, 1, Integer::sum);
        }
        for (int n : nums) {
            int count = counts.get(n);
            if (count <= 0) continue;
            else if (tail.getOrDefault(n - 1, 0) > 0) {
                counts.put(n, count - 1);
                tail.put(n - 1, tail.get(n - 1) - 1);
                tail.put(n, tail.getOrDefault(n, 0) + 1);
            } else if (counts.getOrDefault(n + 1, 0) > 0 && counts.getOrDefault(n + 2, 0) > 0) {
                counts.put(n, count - 1);
                counts.put(n + 1, counts.get(n + 1) - 1);
                counts.put(n + 2, counts.get(n + 2) - 1);
                tail.put(n + 2, tail.getOrDefault(n + 2, 0) + 1);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
