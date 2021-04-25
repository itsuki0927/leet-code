package isSubsequence;

/**
 * 解题思路: 双指针
 *
 * @author: itsuki
 * @create: 2021-04-25 16:50
 **/
public class Solution {
    public static boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        // 两个指针指向s、t
        int i = 0, j = 0;
        while (i < m && j < n) {
            // 如果相等比较s的下一个字符
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == m;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("axc", "aedbfdc"));
    }
}
