package jump;

/**
 * @author: itsuki
 * @create: 2021-04-26 15:54
 **/
public class Solution2 {
    public static int jump(int[] nums) {
        int step = 0; // 记录走的最大步数
        int position = 0; // 当前覆盖的最远距离
        int nextPosition = 0; // 下一步覆盖的最远距离
        int n = nums.length - 1; // 小于 size -1
        for (int i = 0; i < n; i++) {
            // 找到下一步覆盖的最远距离
            nextPosition = Math.max(nextPosition, nums[i] + i);
            // 如果走到了当前覆盖的最远距离
            if (i == position) {
                // 更新到下一步覆盖的最远距离
                position = nextPosition;
                // 更新step
                step++;
            }
        }
        return step;
    }
}
