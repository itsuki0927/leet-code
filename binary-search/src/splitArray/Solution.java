package splitArray;

/**
 * @author: itsuki
 * @create: 2021-05-20 08:01
 **/
public class Solution {
    // 如果进行分组
    public int split(int[] nums, int mid) {
        // 默认就自己一个组
        int count = 1, sum = 0;
        for (int num : nums) {
            sum += num;
            // 如果小组和 > mid
            if (sum > mid) {
                // 开辟一个新组
                count++;
                // 重置sum
                sum = num;
            }
        }
        return count;
    }

    public int splitArray(int[] nums, int m) {
        // 查找范围是 [maxNum, sumNum]之间
        int left = Integer.MIN_VALUE, right = 0;
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            int n = split(nums, mid);
            // 如果分的组数 > 目标组数, 数小了, 所以下一个搜索区间为: [mid+1, right]
            if (n > m) {
                left = mid + 1;
            } else {
                // 否则就是 [left, mid]
                right = mid;
            }
        }
        return left;
    }
}
