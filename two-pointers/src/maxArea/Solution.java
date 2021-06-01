package maxArea;

/**
 * @author: itsuki
 * @create: 2021-06-01 11:02
 **/
public class Solution {
    public int maxArea(int[] height) {
        int length = height.length;
        int result = 0, left = 0, right = length - 1;

        while (left < right) {
            int l = height[left], r = height[right];
            int area = (right - left) * Math.min(l, r);
            result = Math.max(area, result);

            if (l < r) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxArea(new int[]{1, 2, 1}));
    }
}
