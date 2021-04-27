package canCompleteCircuit;

/**
 * 解题思路:
 * 1. 如果总收益 < 开销, 不能全部走完
 * 2. 如果局部的收益 < 0, 清空局部的, 起点往后走
 *
 * @author: itsuki
 * @create: 2021-04-27 11:04
 **/
public class Solution2 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0, start = 0, total = 0;
        for (int i = 0; i < gas.length; i++) {
            // 计算差值
            int div = gas[i] - cost[i];
            total += div;
            sum += div;
            // 一个站收益小于0, 不能作为起点
            if (sum < 0) {
                start = i + 1;
                sum = 0;
            }
        }
        // 如果总体收益小于 0, 不能全部走完
        if (total < 0) return -1;
        return start;
    }
}
