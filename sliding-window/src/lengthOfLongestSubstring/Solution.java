package lengthOfLongestSubstring;

/**
 * 解题思路: 暴力破解
 *
 * @author: itsuki
 * @create: 2021-05-28 08:07
 **/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0, start = 0, end = 0, result = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int k = start; k < end; k++) {
                if (chars[k] == chars[i]) {
                    start = i + 1;
                    max = end - start;
                    break;
                }
            }
            max++;
            end++;
            result = Math.max(result, max);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abacabd"));
    }
}
