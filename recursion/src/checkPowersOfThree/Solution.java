package checkPowersOfThree;

import java.sql.PreparedStatement;
import java.util.HashMap;

/**
 * @author: itsuki
 * @create: 2021-06-14 08:19
 **/
public class Solution {
    boolean result = false;

    public boolean checkPowersOfThree(int n) {
        if (n == 1) return true;
        dfs(n, 0, 0);
        return result;
    }

    private void dfs(int n, int start, int sum) {
        if (sum > n) return;
        if (sum == n) {
            result = true;
            return;
        }

        for (int index = start; index <= 14; index++) {
            int num = (int) Math.pow(3, index);
            if (num > n) break;
            sum += num;
            dfs(n, index + 1, sum);
            sum -= num;
        }

    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkPowersOfThree(12));
    }
}
