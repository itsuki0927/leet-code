package maxTurbulenceSize;

/**
 * @author: itsuki
 * @create: 2021-05-31 12:45
 **/
public class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int result = 1, length = arr.length;
        if (length <= 1) return length;
        int left = 0, right = 1;
        boolean pre = false;
        while (right < length) {
            boolean current = arr[right] < arr[right - 1];
            // 如果相等有两种情况
            // 1. 递增
            // 2. 递减
            if (pre == current) {
                // 移动right的前一个
                left = right - 1;
            }
            // 如果是相同的元素
            if (arr[right] == arr[right - 1]) {
                // 移动到right
                left = right;
            }
            // 移动right
            right++;
            // 更新距离
            result = Math.max(right - left, result);
            // 更新pre标志位
            pre = current;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxTurbulenceSize(new int[]{0, 1, 1, 0, 1, 0, 1, 1, 0, 0}));
    }
}