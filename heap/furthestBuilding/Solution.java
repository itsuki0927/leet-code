package furthestBuilding;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 解题思路: 优先使用梯子, 梯子不够再选取最小的出堆该用砖头(小根堆)
 **/
public class Solution {
    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        int length = heights.length;
        // 小根堆
        PriorityQueue<Integer> queue = new PriorityQueue(Comparator.<Integer>comparingInt(o -> o));
        for (int i = 1; i < length; i++) {
            // 计算需要的砖头数
            int height = heights[i] - heights[i - 1];
            // 大于零才处理, <=0不需要砖头/梯子
            if (height > 0) {
                queue.add(height);
                // 如果梯子不够则使用砖头
                if (queue.size() > ladders) {
                    bricks -= queue.poll();
                }
                // 砖头不够就返回
                if (bricks < 0) {
                    return i - 1;
                }
            }
        }
        return length - 1;
    }

    public static void main(String[] args) {

    }
}
