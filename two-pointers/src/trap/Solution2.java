package trap;

/**
 * @author: itsuki
 * @create: 2021-06-02 09:09
 **/
public class Solution2 {
    public int trap(int[] height) {
        int length = height.length;
        if (length < 3) {
            return 0;
        }
        // 注意初值的选取，前面做了特判，下标 0 和 len - 1 位置都不存雨水，因此这里有效
        // 在区间 [1, len - 2] 里计算存水量
        int left = 1, right = length - 2, result = 0;
        // 保存[0, left-1] 最大高度
        int currentLeftHighest = height[0];
        // 保存[right+1, length-1] 最大高度
        int currentRightHighest = height[length - 1];

        while (left <= right) {
            // 木板效应
            int minHeight = Math.min(currentLeftHighest, currentRightHighest);

            if (minHeight == currentLeftHighest) {
                // 大于当前可以存水
                if (minHeight > height[left]) {
                    result += minHeight - height[left];
                }
                // 更新[0, left-1]最大高度
                currentLeftHighest = Math.max(currentLeftHighest, height[left]);
                left++;
            } else {
                if (minHeight > height[right]) {
                    result += minHeight - height[right];
                }
                // 更新[right+1, length-1]最大高度
                currentRightHighest = Math.max(currentRightHighest, height[right]);
                right--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
