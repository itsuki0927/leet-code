package checkInclusion;

/**
 * @author: itsuki
 * @create: 2021-05-30 10:22
 **/
public class Solution {
    public boolean compare(int[] map1, int[] map2) {
        for (int i = 0; i < 26; i++) {
            if (map1[i] != map2[i]) return false;
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        int sLen1 = s1.length(), sLen2 = s2.length();
        if (sLen1 > sLen2 || s1.equals("") || s2.equals("")) return false;
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        char[] chars = s2.toCharArray();
        for (int i = 0; i < sLen1; i++) {
            map1[s1.charAt(i) - 'a']++;
        }
        int left = 0, right = 0;

        while (right < sLen2) {
            // 进入当前窗口
            map2[chars[right] - 'a']++;
            // 指针右移
            right++;

            // 移除无关/多余的字符
            while (left < sLen2 && map2[chars[left] - 'a'] > map1[chars[left] - 'a']) {
                map2[chars[left] - 'a']--;
                left++;
            }
            // 比较两个map
            if (right - left == sLen1) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkInclusion("axb", "eidbaooo"));
    }
}
