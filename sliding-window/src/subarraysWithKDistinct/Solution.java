package subarraysWithKDistinct;

/**
 * @author: itsuki
 * @create: 2021-05-31 15:34
 **/
public class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        // 恰好为k = 最多k - 最多k-1
        return atMostDistinct(nums, k) - atMostDistinct(nums, k - 1);
    }

    // 最多k个不同整数的子数组
    private int atMostDistinct(int[] nums, int k) {
        int result = 0, length = nums.length;
        int[] freq = new int[length + 1];
        int left = 0, right = 0, count = 0;
        while (right < length) {
            if (freq[nums[right]] == 0) {
                count++;
            }
            freq[nums[right]]++;
            right++;

            while (count > k) {
                freq[nums[left]]--;
                if (freq[nums[left]] == 0) {
                    count--;
                }
                left++;
            }
            result += right - left;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2));
    }
}
