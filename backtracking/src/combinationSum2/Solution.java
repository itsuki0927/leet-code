package combinationSum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: itsuki
 * @create: 2021-06-15 13:48
 **/
public class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int length = candidates.length;
        if (length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        ArrayList<Integer> path = new ArrayList<>();

        dfs(candidates, target, 0, path);

        return result;
    }

    private void dfs(int[] candidates, int target, int start, ArrayList<Integer> path) {
        if (target < 0) return;
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // 如果大于target了, 表示元素不满足, 直接return
            if (candidates[i] > target) return;
            // 去除重复元素
            // i > start表示不可以让同一层级，出现相同的元素
            if (i > start && candidates[i - 1] == candidates[i]) {
                continue;
            }
            path.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 5, 5, 6};
        Solution solution = new Solution();
        List<List<Integer>> combinationSum = solution.combinationSum2(nums, 8);
        combinationSum.forEach(System.out::println);
    }
}
