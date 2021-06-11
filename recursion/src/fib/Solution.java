package fib;

/**
 * @author: itsuki
 * @create: 2021-06-11 09:52
 **/
public class Solution {
    // 记忆化递归
    public int fib(int n) {
        if (n <= 1) return n;
        int[] map = new int[n + 1];
        map[0] = 0;
        map[1] = 1;
        map[2] = 1;
        return fib(n, map);
    }

    private int fib(int n, int[] map) {
        if (n <= 2) return map[n];
        if (map[n] != 0) {
            return map[n];
        } else {
            map[n] = (fib(n - 1, map) + fib(n - 2, map)) % 1000000007;
        }
        return map[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().fib(43));
    }
}
