package checkInclusion;

/**
 * @author: itsuki
 * @create: 2021-05-30 10:22
 **/
public class Solution2 {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2 || s1.equals("") || s2.equals("")) return false;
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        char[] chars = s2.toCharArray();
        for (int i = 0; i < len1; i++) {
            map1[s1.charAt(i) - 'a']++;
        }
        int left = 0, right = 0;

        while (right < len2) {
            int index = chars[right] - 'a';
            // 进入当前窗口
            map2[index]++;
            // 移除无关/多余的字符
            while (map2[index] > map1[index]) {
                map2[chars[left] - 'a']--;
                left++;
            }
            // 指针右移
            right++;

            if (right - left == len1) return true;

        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().checkInclusion("ab", "eidboaoo"));
    }
}
