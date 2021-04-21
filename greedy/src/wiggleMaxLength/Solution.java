package wiggleMaxLength;

/**
 * 解题思路: 上升选最大, 下降选最小
 *
 * @author: itsuki
 * @create: 2021-04-21 09:33
 **/
public class Solution {
    public static int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return nums.length;
        int ret = 1, flag = 0;
        // flag > 0, 表示上升
        // flag < 0, 表示下降
        for (int i = 1; i < nums.length; i++) {
            // 计算差值
            int div = nums[i] - nums[i - 1];
            // flag 上升 && div 下降
            // flag 下降 && div 上升
            if ((flag >= 0 && div < 0) || (flag <= 0 && div > 0)) {
                flag = div;
                ret++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(wiggleMaxLength(new int[]{1, 2, 3, 4, 5}));
    }
}
