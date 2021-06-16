package getPermutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: itsuki
 * @create: 2021-06-16 09:15
 **/
public class Solution {
    boolean[] used;
    int count = 0;
    String result = "";

    public String getPermutation(int n, int k) {
        if (n == 0) return null;
        used = new boolean[n + 1];

        count = k;
        List<Integer> path = new ArrayList<>();
        dfs(n, path);

        return result;
    }

    private void dfs(int n, List<Integer> path) {
        if (count == 0) {
            return;
        }
        if (path.size() == n) {
            count--;
            if (count == 0) {
                StringBuffer s = new StringBuffer();
                for (Integer num : path) {
                    s.append(num);
                }
                result = s.toString();
            }
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!used[i]) {
                path.add(i);
                used[i] = true;
                dfs(n, path);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution().getPermutation(3, 3));
    }
}
