package subsetsWithDup;

import subsets.Solution2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: itsuki
 * @create: 2021-06-15 10:42
 **/
public class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return result;
        }

        Arrays.sort(nums);
        ArrayList<Integer> path = new ArrayList<>();
        dfs(nums, 0, path);
        return result;
    }

    private void dfs(int[] nums, int start, ArrayList<Integer> path) {
        result.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {
            // 去除重复元素
            if (i > start && nums[i - 1] == nums[i]) continue;
            path.add(nums[i]);
            dfs(nums, i + 1, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        Solution solution = new Solution();
        List<List<Integer>> subsets = solution.subsetsWithDup(nums);
        subsets.forEach(System.out::println);
    }
}
