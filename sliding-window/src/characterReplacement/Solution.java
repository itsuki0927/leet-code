package characterReplacement;

/**
 * @author: itsuki
 * @create: 2021-05-30 08:16
 **/
public class Solution {
    public int characterReplacement(String s, int k) {
        int length = s.length();
        if (length < 2) {
            return length;
        }

        int result = 0;
        int left = 0, right = 0;
        int[] freq = new int[26];
        int maxCount = 0;
        char[] chars = s.toCharArray();

        while (right < length) {
            freq[chars[right] - 'A']++;
            maxCount = Math.max(maxCount, freq[chars[right] - 'A']);
            right++;

            // 说明k不够用
            if (right - left > maxCount + k) {
                // 移除当前窗口
                freq[chars[left] - 'A']--;
                left++;
            }

            result = Math.max(right - left, result);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().characterReplacement("AABCABBB", 2));
    }
}
