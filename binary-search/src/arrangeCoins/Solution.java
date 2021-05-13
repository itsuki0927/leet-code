package arrangeCoins;

/**
 * @author: itsuki
 * @create: 2021-05-13 10:14
 **/
public class Solution {
    public static int arrangeCoins(int n) {
        long sum = 0;
        int i = 1;
        if (n == 1) return 1;
        for (; i < n; i++) {
            sum += i;
            if (sum > n) {
                break;
            }
        }
        return i - 1;
    }

    public static void main(String[] args) {
        System.out.println(arrangeCoins(8));
    }
}
