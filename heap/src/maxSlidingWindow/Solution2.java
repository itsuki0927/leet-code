package maxSlidingWindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 解题思路: 双向队列,维护一个单调递减队列, 队首就是最大值
 *
 * @author: itsuki
 * @create: 2021-04-21 08:38
 **/
public class Solution2 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque();
        // 长度为 n - k + 1
        int[] ret = new int[n - k + 1];
        for (int right = 0; right < n; right++) {
            // 如果队列不为空 && 当前元素 >= 队尾的元素
            while (!deque.isEmpty() && nums[right] >= nums[deque.peekLast()]) {
                // 弹出队尾元素
                deque.pollLast();
            }
            // 将当前元素下标添加, 方便进行计算
            deque.offerLast(right);

            // 判断队首元素是否在滑动窗口中
            while (deque.peekFirst() <= right - k) {
                deque.pollFirst();
            }
            // 形成了滑动窗口
            if (right + 1 >= k) {
                // 将每次的滑动窗口的最大值保存到ret中
                ret[right - k + 1] = nums[deque.peekFirst()];
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] ret = maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(ret));
    }
}
