package subsets;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: itsuki
 * @create: 2021-06-14 12:15
 **/
public class Solution3 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        result = new ArrayList<>();
        if (len == 0) {
            return result;
        }
        Stack<Integer> stack = new Stack<>();
        dfs(nums, 0, len, stack);
        return result;
    }

    private void dfs(int[] nums, int index, int length, Stack<Integer> stack) {
        if (length == index) {
            result.add(new ArrayList<>(stack));
            return;
        }
        // 当前数可选，也可以不选

        // 不选，直接进入下一层
        dfs(nums, index + 1, length, stack);

        // 选择当前数, 进入下一层
        stack.push(nums[index]);
        dfs(nums, index + 1, length, stack);
        stack.pop();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution3 solution = new Solution3();
        List<List<Integer>> subsets = solution.subsets(nums);
        subsets.forEach(System.out::println);
    }
}
