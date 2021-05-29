package lengthOfLongestSubstring;

/**
 * 解题思路: 滑动窗口 + 数组
 *
 * @author: itsuki
 * @create: 2021-05-28 08:07
 **/
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int left = 0, right = 0, result = 1;
        int[] windows = new int[128];

        while (right < length) {
            char currChar = s.charAt(right);
            windows[currChar]++;
            right++;

            while (windows[currChar] == 2) {
                char leftChar = s.charAt(left);
                windows[leftChar]--;
                left++;
            }

            result = Math.max(result, right - left);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().lengthOfLongestSubstring("abacabd"));
    }
}
