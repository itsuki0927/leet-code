package minWindow;

import java.util.HashMap;
import java.util.Set;

/**
 * @author: itsuki
 * @create: 2021-05-29 09:42
 **/
public class Solution {
    public boolean compare(HashMap<Character, Integer> targetMap, HashMap<Character, Integer> sourceMap) {
        Set<Character> keySet = targetMap.keySet();
        for (char key : keySet) {
            if (sourceMap.get(key) == null || sourceMap.get(key) < targetMap.get(key)) {
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {
        int length = s.length();
        int targetLength = t.length();
        if (length < targetLength) return "";
        String result = "";
        HashMap<Character, Integer> targetMap = new HashMap<>();
        HashMap<Character, Integer> sourceMap = new HashMap<>();
        char[] source = s.toCharArray();
        for (int i = 0; i < t.length(); i++) {
            targetMap.put(t.charAt(i), targetMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0, right = 0;

        while (right < length) {
            sourceMap.put(source[right], sourceMap.getOrDefault(source[right], 0) + 1);

            if (right - left + 1 >= targetLength) {
                while (compare(targetMap, sourceMap)) {
                    String substring = s.substring(left, right + 1);
                    if (result.equals("")) {
                        result = substring;
                    } else {
                        result = result.length() < substring.length() ? result : substring;
                    }
                    sourceMap.put(source[left], sourceMap.get(source[left]) - 1);
                    left++;
                }
            }

            right++;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
    }
}
