package findSubsequences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author: itsuki
 * @create: 2021-06-16 11:07
 **/
public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    HashMap<String, Boolean> hashMap = new HashMap<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums.length == 0) return result;

        List<Integer> path = new ArrayList<>();
        dfs(nums, 0, path);

        return result;
    }

    private void dfs(int[] nums, int start, List<Integer> path) {
        if (path.size() >= 2) {
            if (!hashMap.containsKey(path.toString())) {
                hashMap.put(path.toString(), true);
                result.add(new ArrayList<>(path));
            }
        }

        for (int i = start; i < nums.length; i++) {
            if (path.isEmpty() || nums[i] >= path.get(path.size() - 1)) {
                path.add(nums[i]);
                dfs(nums, i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> subsequences = solution.findSubsequences(new int[]{4, 6, 7, 7});
        for (List<Integer> list : subsequences) {
            System.out.println(list.toString());
        }
    }
}
