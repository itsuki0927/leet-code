package canJump;

/**
 * 解题思路: 将问题转换为最大覆盖范围可不可以覆盖到终点
 * <p>
 * 局部最优解: 每次取最大跳跃步数(也就是最大覆盖范围)
 * 全局最优解: 得到整体最大覆盖范围, 是否能到终点
 *
 * @author: itsuki
 * @create: 2021-04-26 09:17
 **/
public class Solution {
    public static boolean canJump(int[] nums) {
        int cover = nums[0], n = nums.length;
        if (nums.length <= 1) return true;
        // 在cover范围内进行移动
        for (int i = 0; i <= cover; i++) {
            // cover 取 max(该元素数值补充后的范围, cover本身范围)
            cover = Math.max(cover, i + nums[i]);
            // 如果cover 大于终点
            if (cover >= n - 1) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{0, 2, 3}));
    }
}
