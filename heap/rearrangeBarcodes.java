/**
 * 解题思路: 哈希表 + 大根堆 + 贪心思想
 * 
 * 1. 用counts统计每个数的次数
 * 2. 建立大根堆, 每次拿出频率最高的两个数, 相邻放入, 如果还有剩下的就返回大根堆中
 * 3. 最后处理剩下的数
 */
public class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int[] counts = new int[10001], ret = new int[barcodes.length];
        for (int n : barcodes) counts[n]++;
        PriorityQueue<Integer> queue = new PriorityQueue((Comparator<Integer>) (o1, o2) -> counts[o2] - counts[o1]);
        for (int i = 0; i < 10001; i++) {
            if (counts[i] != 0) queue.add(i);
        }
        int index = 0;
        while (queue.size() > 1) {
            // 依赖拿两个数放入
            int n1 = queue.poll();
            int n2 = queue.poll();
            ret[index++] = n1;
            ret[index++] = n2;
            // 如果还有剩下的, 放入大根堆中
            if (counts[n1] > 1) {
                counts[n1]--;
                queue.add(n1);
            }
            if (counts[n2] > 1) {
                counts[n2]--;
                queue.add(n2);
            }
        }
        // 还有剩下的依次放入
        if (!queue.isEmpty()) ret[index++] = queue.poll();
        return ret;
    }
}

