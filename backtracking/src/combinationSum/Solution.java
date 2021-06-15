package combinationSum;

import subsets.Solution2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: itsuki
 * @create: 2021-06-15 12:55
 **/
public class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int length = candidates.length;
        if (length == 0) return result;
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        dfs(candidates, target, 0, path);
        return result;
    }

    private void dfs(int[] candidates, int target, int start, List<Integer> path) {
        if (target < 0) return;

        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) return;
            path.add(candidates[i]);
            // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
            dfs(candidates, target - candidates[i], i, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 5};
        Solution solution = new Solution();
        List<List<Integer>> combinationSum = solution.combinationSum(nums, 8);
        combinationSum.forEach(System.out::println);
    }
}
