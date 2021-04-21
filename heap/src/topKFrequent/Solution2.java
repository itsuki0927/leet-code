package topKFrequent;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 解题思路: 哈希表+大根堆, 先用哈希表统计次数, 然后添加到大根堆中, 堆顶k个元素就是频率最高的k个元素
 */
public class Solution2 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        // 先统计出现次数
        for (int num : nums) {
            hashMap.merge(num, 1, Integer::sum);
        }
        // 根据统计次数建立大根堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(hashMap::get));
        int[] ret = new int[k];
        Set<Integer> integers = hashMap.keySet();
        // 将统计后的key添加到添加到大根堆
        for (int num : integers) {
            queue.add(num);
        }
        // 弹出 k 个就是最终结果
        for (int i = 0; i < nums.length - k && !queue.isEmpty(); i++) {
            ret[i] = queue.poll();
        }
        return ret;
    }
}