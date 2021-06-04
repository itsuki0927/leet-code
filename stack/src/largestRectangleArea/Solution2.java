package largestRectangleArea;

import java.util.Stack;

/**
 * @author: itsuki
 * @create: 2021-06-03 14:06
 **/
public class Solution2 {
    public int largestRectangleArea(int[] heights) {
        int result = 0;
        int length = heights.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int currentHeight = heights[stack.pop()];
                while (!stack.isEmpty() && heights[stack.peek()] == currentHeight) {
                    stack.pop();
                }

                int currentWidth;
                if (stack.isEmpty()) {
                    currentWidth = i;
                } else {
                    currentWidth = i - stack.peek() - 1;
                }
                result = Math.max(currentWidth * currentHeight, result);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int currentHeight = heights[stack.pop()];
            while (!stack.isEmpty() && heights[stack.peek()] == currentHeight) {
                stack.pop();
            }
            int currentWidth;
            if (stack.isEmpty()) {
                currentWidth = length;
            } else {
                currentWidth = length - stack.peek() - 1;
            }
            result = Math.max(currentHeight * currentWidth, result);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().largestRectangleArea(new int[]{2, 1, 5, 6, 7, 4, 3}));
    }
}
