package lemonadeChange;

/**
 * 解题思路: 贪心
 * 维护三种金额的数量: 5、10和20
 * 1. 情况一: 账单是5, 直接收下
 * 2. 情况二: 账单是10, 消耗一个5, 收下一个10
 * 3. 情况三: 账单是20, 优先消耗一个10和5、或者消耗3个5
 *
 * @author: itsuki
 * @create: 2021-04-28 17:31
 **/
public class Solution {
    public static boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            // 如果是5, 直接收下
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                // 如果 5 消耗完了, 返回false
                if (five <= 0) return false;
                // 消耗一个 5
                five--;
                // 收下一个 10
                ten++;
            } else if (bill == 20) {
                // 如果有10和5, 优先消耗
                if (ten > 0 && five >= 1) {
                    ten--;
                    five--;
                }
                // 其次使用3个5
                else if (five >= 3) {
                    five -= 3;
                } else {
                    // 都没有, 表示不能找零
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(lemonadeChange(new int[]{5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 20, 5}));
    }
}
