package maximumSwap;

/**
 * 解题思路:
 * 1. 我们将计算last[d] = i，最后一次出现的数字 d（如果存在）的索引 i.
 * 2. 然后，从左到右扫描数字时，如果将来有较大的数字，我们将用最大的数字交换；如果有多个这样的数字，我们将用最开始遇到的数字交换。
 *
 * @author: itsuki
 * @create: 2021-04-25 08:42
 **/
public class Solution {
    private static void swap(char[] chars, int i, int j) {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }

    public static int maximumSwap(int num) {
        String s = String.valueOf(num);
        int length = s.length();
        char[] chars = s.toCharArray();
        int[] indexes = new int[10];

        // 记录每个数字出现的最后下标
        for (int i = 0; i < length; i++) {
            indexes[chars[i] - '0'] = i;
        }

        int n, index;
        // 从左至右找, 找到位置最大的数进行交换
        for (int i = 0; i < length; i++) {
            // 从后往前找
            n = chars[i] - '0';
            for (int j = 9; j > n; j--) {
                // 如果后面的索引大于当前字符的索引进行交换
                index = indexes[j];
                if (index > i) {
                    swap(chars, i, index);
                    // 只允许交换一次
                    return Integer.parseInt(String.valueOf(chars));
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(maximumSwap(7236));
    }
}
