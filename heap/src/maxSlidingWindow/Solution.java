package maxSlidingWindow;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 解题思路: 维护最大堆, 然后每次添加后判断堆顶元素在不在滑动窗口中, 不在的话从堆顶弹出
 *
 * @author: itsuki
 * @create: 2021-04-21 08:14
 **/
public class Solution {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        // 建立大根堆, 如果值相同比较下标
        PriorityQueue<int[]> queue = new PriorityQueue((Comparator<int[]>) (o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1]);
        // 答案有 length - k + 1 个
        int[] ret = new int[length - k + 1];
        // 先添加k个
        for (int i = 0; i < k; i++) {
            queue.add(new int[]{nums[i], i});
        }
        // 将第一个元素添加到答案中
        ret[0] = queue.peek()[0];
        for (int i = k; i < length; i++) {
            queue.add(new int[]{nums[i], i});
            // 判断当前堆顶在不在滑动窗口内
            while (queue.peek()[1] <= i - k) {
                queue.poll();
            }
            // 将元素添加到滑动窗口中
            ret[i - k + 1] = queue.peek()[0];
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] ret = maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(ret));
    }
}
