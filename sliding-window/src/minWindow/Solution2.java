package minWindow;

/**
 * 解题思路: 滑动窗口
 *
 * @author: itsuki
 * @create: 2021-05-29 09:42
 **/
public class Solution2 {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.equals("") || t.equals("") || s.length() < t.length()) return "";
        int length = s.length(), tLen = t.length();
        int begin = 0, minLength = length + 1;
        int[] have = new int[128];
        int[] need = new int[128];
        int distance = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }

        int left = 0, right = 0;
        while (right < length) {
            char r = chars[right];
            // 如果不在目标字符串, 直接移动右指针
            if (need[r] == 0) {
                right++;
                continue;
            }

            // 当且仅当已有字符串目标字符出现的次数小于目标字符串字符的出现次数时，count才会+1
            if (have[r] < need[r]) {
                distance++;
            }
            // 已有字符串中目标字符出现的次数 + 1
            have[r]++;
            // 移动右指针
            right++;

            // 当且仅当已有字符串已经包含了所有目标字符串的字符，且出现频次一定大于或等于指定频次
            while (distance == tLen) {
                // 记录最小子串
                if (minLength > right - left) {
                    minLength = right - left;
                    begin = left;
                }

                char l = chars[left];
                // 如果不在need中, 直接移动左指针
                if (need[l] == 0) {
                    left++;
                    continue;
                }

                // 如果去掉的是目标字符串的元素
                // 去掉之后, 不满足子串的条件, distance--及时跳出循环
                if (have[l] == need[l]) {
                    distance--;
                }
                // 已有字符串中目标字符出现的次数-1
                have[l]--;
                // 移动左指针
                left++;
            }
        }

        if (minLength == length + 1) {
            return "";
        }

        return s.substring(begin, begin + minLength);
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().minWindow("ADOBECODEBANC", "ABC"));
    }
}
