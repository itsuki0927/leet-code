package merge;

import java.util.*;

/**
 * 解题思路: 贪心
 *
 * @author: itsuki
 * @create: 2021-05-03 21:23
 **/
public class Solution {
    public static int[][] merge(int[][] intervals) {
        List<int[]> ret = new ArrayList<>();
        // 根据起点进行排序
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int start = intervals[0][0], end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            // 如果前一个终点 > 当前终点
            // 表示可以合并区间
            if (end >= intervals[i][0]) {
                end = Math.max(intervals[i][1], end);
            } else {
                // 如果不能进行合并
                ret.add(new int[]{start, end});
                // 更新起点、终点
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        // 添加最后一个区间
        ret.add(new int[]{start, end});
        return ret.toArray(new int[ret.size()][2]);
    }

    public static void main(String[] args) {
        int[][] ints = new int[4][2];
        ints[0] = new int[]{1, 20};
        ints[1] = new int[]{4, 6};
        ints[2] = new int[]{8, 10};
        ints[3] = new int[]{12, 15};
        int[][] merge = merge(ints);
        for (int i = 0; i < merge.length; i++) {
            System.out.println(Arrays.toString(merge[i]));
        }
    }
}
