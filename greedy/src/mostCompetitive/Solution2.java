package mostCompetitive;

import java.util.Arrays;

/**
 * 解题思路: 单调栈
 *
 * @author: itsuki
 * @create: 2021-04-25 10:11
 **/
public class Solution2 {
    public static int[] mostCompetitive(int[] nums, int k) {
        int[] stack = new int[k];
        // 移除的数字量
        int top = 0, drop = nums.length - k;
        for (int num : nums) {
            // 如果可以移除数字 && 单调栈大小 > 0 && 栈顶元素 > 当前元素
            while (drop > 0 && top > 0 && stack[top - 1] > num) {
                // 移除一个数字
                drop--;
                // 弹出栈顶元素
                top--;
            }
            // 小于k, 栈没满, 直接添加
            if (top < k) stack[top++] = num;
                // 栈满了, 直接丢弃
            else --drop;
        }
        return stack;
    }

    public static void main(String[] args) {
//        int[] n = new int[]{2, 4, 3, 3, 5, 4, 9, 6};
        int[] n = new int[]{71, 18, 52, 29, 55, 73, 24, 42, 66, 8, 80, 2};
        System.out.println(Arrays.toString(mostCompetitive(n, 3)));
    }
}
