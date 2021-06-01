package longestSubarray;

/**
 * @author: itsuki
 * @create: 2021-06-01 10:08
 **/
public class Solution2 {
    public int longestSubarray(int[] nums) {
        int result = 0, length = nums.length;
        int left = 0, right = 0, ones = 0, maxCount = 0;

        while (right < length) {
            // 统计1出现的次数
            if (nums[right] == 1) {
                ones++;
            }
            // 删除一个元素以后全为 1 的最长的子串的长度
            maxCount = Math.max(maxCount, ones);
            right++;

            // maxCount + 1 里的 1 就表示删除的那个元素
            while (right - left > maxCount + 1) {
                if (nums[left] == 1) {
                    ones--;
                }
                left++;
            }

            result = Math.max(result, right - left);
        }

        return result - 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().longestSubarray(new int[]{0, 0, 0}));
    }
}
