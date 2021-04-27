package canCompleteCircuit;

/**
 * 解题思路: 暴力破解
 *
 * @author: itsuki
 * @create: 2021-04-27 10:36
 **/
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int index, rest, length = gas.length;
        for (int i = 0; i < length; i++) {
            rest = gas[i] - cost[i]; // 记录剩余油量
            index = (i + 1) % length;
            while (rest > 0 && index != i) { // 以 i 为起点绕圈
                rest += gas[index] - cost[index];
                index = (index + 1) % length;
            }
            // 如果还有油量 && 回到起点则返回
            if (rest >= 0 && index == i) return i;
        }
        return -1;
    }
}
