package topKFrequent;


import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 解题思路: 哈希表+小根堆, 先用哈希表统计次数, 然后添加到小根堆中, 如果堆中元素个数小于k时,一直添加, 如果 == k时,进行
 * 进行判断如果当前num出现次数大于堆顶元素时, 弹出堆顶元素, 将num添加到小根堆中, 最后在小根堆的元素就是频率最高的k个元素
 */
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        // 先统计出现次数
        for (int num : nums) {
            hashMap.merge(num, 1, Integer::sum);
        }
        // 根据统计次数建立小根堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(hashMap::get));
        int[] ret = new int[k];
        Set<Integer> integers = hashMap.keySet();
        for (int num : integers) {
            // 小于k进行添加
            if (queue.size() < k) {
                queue.add(num);
            } else if (hashMap.get(num) > hashMap.get(queue.peek())) {
                queue.poll();
                queue.add(num);
            }
        }
        System.out.println(queue);
        // 弹出 k 个就是最终结果
        for (int i = 0; i < k && !queue.isEmpty(); i++) {
            ret[i] = queue.poll();
        }
        return ret;
    }
}

