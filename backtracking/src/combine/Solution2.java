package combine;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: itsuki
 * @create: 2021-06-15 12:33
 **/
public class Solution2 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> coll = new ArrayList<>();
        dfs(n, k, 1, coll);
        return result;
    }

    private void dfs(int n, int k, int start, List<Integer> coll) {
        if (coll.size() == k) {
            result.add(new ArrayList<>(coll));
            return;
        }

        // n - (k-coll.size()) + 1
        // 剪枝
        for (int i = start; i <= n - (k - coll.size()) + 1; i++) {
            coll.add(i);
            dfs(n, k, i + 1, coll);
            coll.remove(coll.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        List<List<Integer>> subsets = solution.combine(4, 2);
        subsets.forEach(System.out::println);
    }
}
