package largestRectangleArea;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author: itsuki
 * @create: 2021-06-03 14:06
 **/
public class Solution3 {
    public int largestRectangleArea(int[] heights) {
        int result = Integer.MIN_VALUE;

        // 前后尾部都加0
        // 前面的0可以不用判断栈是否为空
        // 尾部的0可以把最后单调栈的元素全部都压出来
        int[] temp = new int[heights.length + 2];
        System.arraycopy(heights, 0, temp, 1, heights.length);
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        for (int i = 0; i < temp.length; i++) {
            while (!stack.isEmpty() && temp[stack.peek()] > temp[i]) {
                int currentHeight = temp[stack.pop()];
                int currentWidth = i - stack.peek() - 1;
                result = Math.max(currentWidth * currentHeight, result);
            }
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().largestRectangleArea(new int[]{2, 1, 5, 6, 7, 4, 3}));
    }
}
