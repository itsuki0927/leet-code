package merge;

import java.util.Arrays;

/**
 * 解题思路: 贪心
 *
 * @author: itsuki
 * @create: 2021-05-03 21:23
 **/
public class Solution2 {
    public static int[][] merge(int[][] intervals) {
        // 根据起点进行排序
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int index = -1;
        int[][] ret = new int[intervals.length][2];
        for (int[] interval : intervals) {
            // 如果结果数组是空的, 或者当前区间的起始位置 > 结果数组中最后区间的终止位置,
            // 则不合并, 直接将当前区间加入结果数组
            if (index == -1 || interval[0] > ret[index][1]) {
                ret[++index] = interval;
            } else {
                // 合并区间
                ret[index][1] = Math.max(ret[index][1], interval[1]);
            }
        }
        return Arrays.copyOf(ret, index + 1);
    }

    public static void main(String[] args) {
        int[][] ints = new int[4][2];
        ints[0] = new int[]{1, 3};
        ints[1] = new int[]{2, 6};
        ints[2] = new int[]{8, 10};
        ints[3] = new int[]{12, 15};
        int[][] merge = merge(ints);
        for (int i = 0; i < merge.length; i++) {
            System.out.println(Arrays.toString(merge[i]));
        }
    }
}
