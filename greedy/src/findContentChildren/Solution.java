package findContentChildren;

import java.util.Arrays;

/**
 * 解题思路: 贪心, 用尽量小的饼干去满足小需求的孩子，所以需要进行排序先
 *
 * @author: itsuki
 * @create: 2021-04-21 09:14
 **/
public class Solution {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int n1 = g.length, n2 = s.length, child = 0, cookie = 0;
        while (child < n1 && cookie < n2) {
            // 如果饼干满足当前孩子, 孩子往后移
            if (g[child] <= s[cookie]) {
                child++;
            }
            // 饼干只可以用一次
            cookie++;
        }
        return child;
    }

    public static void main(String[] args) {
        System.out.println(findContentChildren(new int[]{5, 10, 2, 9, 15, 9}, new int[]{6, 1, 20, 3, 8}));
    }
}
