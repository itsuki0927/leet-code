package largestRectangleArea;

/**
 * @author: itsuki
 * @create: 2021-06-03 14:06
 **/
public class Solution {
    public int largestRectangleArea(int[] heights) {
        int result = 0, length = heights.length;

        for (int i = 0; i < length; i++) {
            int left = i;
            int currentHeight = heights[i];
            // 向左边扩展
            while (left > 0 && heights[left - 1] >= currentHeight) left--;

            int right = i;
            // 向右边扩展
            while (right < length - 1 && heights[right + 1] >= currentHeight) right++;

            result = Math.max(result, (right - left + 1) * currentHeight);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largestRectangleArea(new int[]{1, 1}));
    }
}
