package candy;

/**
 * 解题思路: 贪心
 * <p>
 * 1. 一次从左到右遍历, 只比较右边评分比左边大的情况
 * 2. 一次从右到左遍历, 只比较左边评分比右边大的情况
 *
 * @author: itsuki
 * @create: 2021-04-28 17:05
 **/
public class Solution {
    public static int candy(int[] ratings) {
        int ret = 0, n = ratings.length;
        int[] candy = new int[n];
        // 第一次遍历, 处理右边>左边
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                // 只需要多一个即可
                candy[i] = candy[i - 1] + 1;
            }
        }

        // 第二次遍历, 处理左边>右边
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                // 只有比较candy[i]、candy[i+1]+1, 才能满足比左边孩子和右边孩子的糖果多
                candy[i] = Math.max(candy[i], candy[i + 1] + 1);
            }
        }

        // 统计个数
        for (int i = 0; i < n; i++) {
            ret += candy[i];
        }
        return ret + n;
    }

    public static void main(String[] args) {
        System.out.println(candy(new int[]{1, 2, 2}));
    }
}
