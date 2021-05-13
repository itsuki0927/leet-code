package findRightInterval;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * 解题思路: 哈希表建立索引, 然后利用二分查找来找到第一个>=的元素, 取出对应下标
 *
 * @author: itsuki
 * @create: 2021-05-13 08:42
 **/
public class Solution2 {
    public static int[] findRightInterval(int[][] intervals) {
        int length = intervals.length;
        if (length == 1) return new int[]{-1};
        int[] result = new int[length];
        HashMap<int[], Integer> indexMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            indexMap.put(intervals[i], i);
        }
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        for (int[] interval : intervals) {
            int target = interval[1];
            int left = binarySearch(intervals, target);
            result[indexMap.get(interval)] = intervals[left][0] < target ? -1 : indexMap.get(intervals[left]);
        }
        return result;
    }

    private static int binarySearch(int[][] intervals, int target) {
        int left = 0, right = intervals.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // < target肯定不在区间内, 所以下一个搜索区间为 [mid+1, right]
            if (intervals[mid][0] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[][] nums = new int[3][2];
        nums[0] = new int[]{3, 4};
        nums[1] = new int[]{2, 3};
        nums[2] = new int[]{1, 2};
        System.out.println(Arrays.toString(findRightInterval(nums)));
    }
}
