package findSubsequences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author: itsuki
 * @create: 2021-06-16 11:07
 **/
public class Solution2 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums.length == 0) return result;

        List<Integer> path = new ArrayList<>();
        dfs(nums, 0, path);

        return result;
    }

    private void dfs(int[] nums, int index, List<Integer> path) {
        if (path.size() >= 2) {
            result.add(new ArrayList<>(path));
        }

        HashSet<Integer> set = new HashSet();
        for (int i = index; i < nums.length; i++) {
            // 保证在同一层不会重复使用相同数字
            if (set.contains(nums[i])) {
                continue;
            }
            if (path.isEmpty() || nums[i] >= path.get(path.size() - 1)) {
                path.add(nums[i]);
                set.add(nums[i]);
                dfs(nums, i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }


    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        List<List<Integer>> subsequences = solution.findSubsequences(new int[]{4, 6, 7, 7});
        for (List<Integer> list : subsequences) {
            System.out.println(list.toString());
        }
    }
}
