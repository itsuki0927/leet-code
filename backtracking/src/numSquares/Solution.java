package numSquares;

/**
 * @author: itsuki
 * @create: 2021-06-18 10:56
 **/
public class Solution {
    int result = Integer.MAX_VALUE;

    public int numSquares(int n) {
        dfs(n, 1, 0);
        return result;
    }

    private void dfs(int n, int start, int count) {
        if (n < 0) return;
        if (n == 0) {
            result = Math.min(count, result);
            return;
        }

        for (int i = start; i <= n; i++) {
            if (i * i > n) return;
            dfs(n - i * i, i, count + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numSquares(1));
    }
}
