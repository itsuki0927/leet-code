package trap;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: itsuki
 * @create: 2021-06-04 10:39
 **/
public class Solution {
    public int trap(int[] height) {
        int result = 0;
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < height.length; i++) {
            while (!deque.isEmpty() && height[deque.peek()] < height[i]) {
                int index = deque.poll();

                // 特殊情况，当栈为空的时候，跳出循环，直接增加当前下标 i 到栈里
                if (deque.isEmpty()) {
                    break;
                }

                // 计算宽度
                int currentWidth = i - deque.peek() - 1;
                // 计算高度
                // Math.min(右边高度, 左边高度) - 当前高度
                int currentHeight = Math.min(height[i], height[deque.peek()]) - height[index];

                result += currentWidth * currentHeight;
            }

            deque.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
