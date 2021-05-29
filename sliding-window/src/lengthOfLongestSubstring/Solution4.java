package lengthOfLongestSubstring;

import java.util.HashMap;

/**
 * 解题思路: 滑动窗口 + 哈希表
 *
 * @author: itsuki
 * @create: 2021-05-28 08:07
 **/
public class Solution4 {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length < 2) return length;
        int left = 0, right = 0, result = 1;
        HashMap<Character, Integer> hashMap = new HashMap<>();

        while (right < length) {
            char rightChar = s.charAt(right);
            // 如果右边界有重复元素
            if (hashMap.containsKey(rightChar)) {
                // 下一个不重复的子串至少在之前重复的那个位置之后
                // 缩小左边界到重复元素的下一个
                left = Math.max(left, hashMap.get(rightChar) + 1);
            }

            // 此时比较窗口的大小
            result = Math.max(right - left + 1, result);
            // 更新右边界索引
            hashMap.put(rightChar, right);
            // 移动右边界
            right++;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution4().lengthOfLongestSubstring("abba"));
    }
}
