package trap;

/**
 * @author: itsuki
 * @create: 2021-06-02 09:09
 **/
public class Solution {
    private int max(int[] height, int left, int right) {
        int result = height[left];
        for (int i = left + 1; i <= right; i++) {
            result = Math.max(result, height[i]);
        }
        return result;
    }

    public int trap(int[] height) {
        int length = height.length;
        if (length < 3) {
            return 0;
        }
        int result = 0;

        for (int i = 1; i <= length - 2; i++) {
            // 计算当前位置左边的最大高度
            int leftHighest = max(height, 0, i - 1);
            // 计算当前位置右边的最大高度
            int rightHighest = max(height, i + 1, length - 1);

            // 木板效应，取最短
            int currentHeight = Math.min(leftHighest, rightHighest);

            // 如果大于就可以存水
            if (currentHeight > height[i]) {
                result += currentHeight - height[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
