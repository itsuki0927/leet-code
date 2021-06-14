package permuteUnique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author: itsuki
 * @create: 2021-06-14 10:29
 **/
public class Solution {
    boolean[] visit;
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        visit = new boolean[nums.length];
        ArrayList<Integer> path = new ArrayList<>();
        Arrays.sort(nums);

        dfs(nums, 0, path);

        return result;
    }

    private void dfs(int[] nums, int depth, ArrayList<Integer> path) {
        if (depth == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 如果已经使用过了
            if (visit[i]) {
                continue;
            }

            // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
            // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            if (i > 0 && nums[i - 1] == nums[i] && !visit[i - 1]) {
                continue;
            }
            visit[i] = true;
            path.add(nums[i]);

            dfs(nums, depth + 1, path);

            visit[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> permute = new Solution().permuteUnique(new int[]{1, 2, 1});
        for (List<Integer> integers : permute) {
            System.out.println(integers.toString());
        }
    }
}
