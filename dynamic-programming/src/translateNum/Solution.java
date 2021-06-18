package translateNum;

import java.util.Arrays;

/**
 * @author: itsuki
 * @create: 2021-06-18 09:45
 **/
public class Solution {
    public int translateNum(int num) {
        String string = String.valueOf(num);
        //dp[i] 代表以nums[]中第i位数字为结尾的数字的翻译方案数量。
        int[] dp = new int[string.length() + 1];
        // 无数字、第1位数字翻译结果都为1
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= string.length(); i++) {
            // 计算当前数和前一个数组成的数值大小,如"1225",那么就是截取出来下标[0,2),也就是12
            String temp = string.substring(i - 2, i);
            // 比较是否在[10,25]之间, 在的话表示可以翻译成
            if (temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                //组成数值不在[10,25]范围内，则只能算一种翻译,和前一个数能翻译的方法数一样
                dp[i] = dp[i - 1];
            }
        }

        return dp[string.length()];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().translateNum(12235));
    }
}
