package subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: itsuki
 * @create: 2021-06-14 12:15
 **/
public class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        result = new ArrayList<>();
        if (len == 0) {
            return result;
        }
        List<Integer> pre = new ArrayList<>();
        dfs(nums, 0, pre);
        return result;
    }

    private void dfs(int[] nums, int start, List<Integer> pre) {
        result.add(new ArrayList<>(pre));

        for (int i = start; i < nums.length; i++) {
            pre.add(nums[i]);
            dfs(nums, i + 1, pre);
            pre.remove(pre.size() - 1);
        }
    }

}
