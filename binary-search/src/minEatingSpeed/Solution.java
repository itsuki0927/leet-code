package minEatingSpeed;

/**
 * 解题思路: 二分查找 + 每次循环统计
 *
 * @author: itsuki
 * @create: 2021-05-15 09:54
 **/
public class Solution {
    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = Integer.MIN_VALUE;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            int time = calcEatingSpeed(piles, mid);

            // 耗时太长, 扩大区间
            if (time > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    // 统计按照speed吃需要多少个小时
    private static int calcEatingSpeed(int[] piles, int speed) {
        int sum = 0;
        for (int pile : piles) {
            sum += (pile + speed - 1) / speed;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] piles = new int[]{30, 11, 23, 4, 20};
        System.out.println(calcEatingSpeed(piles, 23));
        System.out.println(minEatingSpeed(piles, 6));
    }
}
