package arrangeCoins;

/**
 * [0,1,2,3,4,......,n]
 * [0,1,3,6,10,.....,n]
 * 行数和硬币对应关系: (n + 1) * n / 2
 *
 * @author: itsuki
 * @create: 2021-05-13 10:14
 **/
public class Solution2 {
    public static int arrangeCoins(int n) {
        long left = 1, right = n - 1;
        while (left < right) {
            long mid = left + (right - left + 1) / 2;
            long val = (mid + 1) * mid / 2;
            if (val > n) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int) left;
    }

    public static void main(String[] args) {
        System.out.println(arrangeCoins(8));
    }
}
