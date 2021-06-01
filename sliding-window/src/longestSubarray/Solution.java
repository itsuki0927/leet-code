package longestSubarray;

/**
 * @author: itsuki
 * @create: 2021-06-01 10:08
 **/
public class Solution {
    public int longestSubarray(int[] nums) {
        int result = 0, length = nums.length;
        int left = 0, right = 0, flag = 0;

        while (right < length) {
            // 累加0出现的次数
            if (nums[right] == 0) {
                flag++;
            }
            // 移动右指针
            right++;

            // 如果窗口出现了两个0, 移除第一个出现的0
            while (flag > 1) {
                if (nums[left] == 0) {
                    flag--;
                }
                left++;
            }
            // 因为是移除一个元素, 所以计算的时候就是 right - left - 1, -1 就是把那个元素移除掉
            result = Math.max(result, right - left - 1);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestSubarray(new int[]{0, 0, 0}));
    }
}
