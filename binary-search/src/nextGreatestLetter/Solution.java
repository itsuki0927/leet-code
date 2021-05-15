package nextGreatestLetter;

/**
 * 解题思路: 二分查找
 *
 * @author: itsuki
 * @create: 2021-05-15 09:21
 **/
public class Solution {
    public static char nextGreatestLetter(char[] letters, char target) {
        int length = letters.length;
        int left = 0, right = length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            // 排除<=的, 下一个搜索区间 [mid+1, right]
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                // [left, mid]
                right = mid;
            }
        }

        return letters[left % length];
    }

    public static void main(String[] args) {
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'y'));
    }
}
