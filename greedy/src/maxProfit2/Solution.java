package maxProfit2;

/**
 * 解题思路:
 * prices[3] - prices[0] => (prices[3] - prices[2]) + (prices[2] - prices[1]) + (prices[1] - prices[0])
 * 此时就是把利润分解为每天为单位的维度，而不是从0天到第3天整体去考虑
 * <p>
 * 收集正利润的区间, 就是股票买卖的区间, 而我们只需要关注最终利润, 不需要记录区间
 * <p>
 * 局部最优: 收集每天的正利润, 全剧最优: 求得最大利润
 *
 * @author: itsuki
 * @create: 2021-04-26 08:55
 **/
public class Solution {
    public static int maxProfit(int[] prices) {
        int ret = 0, n = prices.length;

        for (int i = 1; i < n; i++) {
            // 收集正利润
            if (prices[i] - prices[i - 1] > 0) {
                ret += prices[i] - prices[i - 1];
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
