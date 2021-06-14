package permute;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: itsuki
 * @create: 2021-06-14 09:57
 **/
public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    boolean[] visit;

    public List<List<Integer>> permute(int[] nums) {
        visit = new boolean[nums.length];
        dfs(nums, 0, new ArrayList<>());
        return result;
    }

    private void dfs(int[] nums, int depth, List<Integer> path) {
        if (depth == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                path.add(nums[i]);
                dfs(nums, depth + 1, path);
                visit[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> permute = new Solution().permute(new int[]{1, 2, 3});
        for (List<Integer> integers : permute) {
            System.out.println(integers.toString());
        }
    }
}
