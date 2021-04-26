package canJump;

/**
 * 解题思路:
 * <p>
 * 1. 如果某一个起跳点的格子是3, 表示后面3个格子都可以作为起跳点
 * 2. 然后把每一个作为起跳点都尝试跳一次, 把能跳到的最远距离不断更新
 * 3. 如果一直能跳到最后, 就成功了
 *
 * @author: itsuki
 * @create: 2021-04-26 09:32
 **/
public class Solution2 {
    public static boolean canJump(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果 i > k 表示
            if (i > k) return false;
            k = Math.max(k, i + nums[i]);
        }
        return true;
    }
}
