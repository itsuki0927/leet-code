package combine;

import subsets.Solution2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: itsuki
 * @create: 2021-06-15 12:33
 **/
public class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> coll = new ArrayList<>();
        dfs(n, k, 1, coll);
        return result;
    }

    private void dfs(int n, int k, int start, List<Integer> coll) {
        // 如果路径中的元素有k个
        if (coll.size() == k) {
            // 添加到结果集中
            result.add(new ArrayList<>(coll));
            return;
        }

        // 遍历所有的搜索起点
        for (int i = start; i <= n; i++) {
            // 向路径添加一个数
            coll.add(i);
            // 下一轮搜索要+1, 因为组合中不允许出现重复的元素
            dfs(n, k, i + 1, coll);
            // 回溯
            coll.remove(coll.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> subsets = solution.combine(4, 2);
        subsets.forEach(System.out::println);
    }
}
