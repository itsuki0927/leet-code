package subsets;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: itsuki
 * @create: 2021-06-14 12:15
 **/
public class Solution2 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        result = new ArrayList<>();
        if (len == 0) {
            return result;
        }
        Stack<Integer> stack = new Stack<>();
        // 递归的时候记录深度
        // 类似于层次遍历
        for (int i = 0; i <= len; i++) {
            dfs(nums, 0, i, stack);
        }
        return result;
    }

    private void dfs(int[] nums, int start, int depth, Stack<Integer> stack) {
        if (depth == stack.size()) {
            result.add(new ArrayList<>(stack));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            stack.push(nums[i]);
            dfs(nums, i + 1, depth, stack);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution2 solution = new Solution2();
        List<List<Integer>> subsets = solution.subsets(nums);
        subsets.forEach(System.out::println);
    }
}
