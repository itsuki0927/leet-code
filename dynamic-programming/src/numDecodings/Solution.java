package numDecodings;

/**
 * @author: itsuki
 * @create: 2021-06-18 10:20
 **/
public class Solution {
    public int numDecodings(String s) {
        if (s.startsWith("0")) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            // 判断截取一个是否符合（只要不是0，都符合）
            if (s.charAt(i - 1) != '0')
                dp[i] = dp[i - 1];
            // 判断截取两个是否符合
            // 因为如果满足了上一个条件, 所以dp[i]已经是dp[i-1], 即之后可能就只需要dp[i]+=dp[i-2]
            if (i >= 2 && (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6'))
                dp[i] += dp[i - 2];
        }
        return dp[n];
    }
}
