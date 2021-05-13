package findRightInterval;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 解题思路: 哈希表 + 遍历
 *
 * @author: itsuki
 * @create: 2021-05-13 08:42
 **/
public class Solution {
    public static int[] findRightInterval(int[][] intervals) {
        int length = intervals.length;
        if (length == 1) return new int[]{-1};
        int[] result = new int[length];
        HashMap<int[], Integer> indexMap = new HashMap();
        for (int i = 0; i < length; i++) {
            indexMap.put(intervals[i], i);
        }
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        for (int i = 0; i < length; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int j = i; j < length; j++) {
                if (intervals[j][0] >= intervals[i][1] && intervals[j][0] < min) {
                    min = intervals[j][0];
                    minIndex = indexMap.get(intervals[j]);
                }
            }
            result[indexMap.get(intervals[i])] = minIndex;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] nums = new int[2][2];
        nums[0] = new int[]{1, 1};
        nums[1] = new int[]{3, 4};
        System.out.println(Arrays.toString(findRightInterval(nums)));
    }
}
