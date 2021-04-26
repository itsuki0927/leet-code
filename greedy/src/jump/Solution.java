package jump;

/**
 * 解题思路: 从覆盖范围出发, 不管怎么跳, 肯定可以跳到终点, 将问题转化为最小步数增加覆盖范围,
 * 覆盖范围一旦覆盖了终点就是, 得到的就是最小步数
 *
 * @author: itsuki
 * @create: 2021-04-26 10:03
 **/
public class Solution {
    public static int jump(int[] nums) {
        int step = 0, start = 0, end = 1, position = 0;
        while (end < nums.length) {
            for (int i = start; i < end; i++) {
                // 在当前范围找可以往后跳的最大范围
                position = Math.max(position, nums[i] + i);
            }
            // 更新开始位置
            start = end;
            // 更新结束位置
            end = position + 1;
            // 加一步
            step++;
        }
        return step;
    }

    public static void main(String[] args) {
//        System.out.println(jump(new int[]{2, 3, 0, 1, 4}));
        System.out.println(jump(new int[]{1, 2, 1, 1, 1}));
    }
}
