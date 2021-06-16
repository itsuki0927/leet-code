package pathSum;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: itsuki
 * @create: 2021-06-16 08:39
 **/
public class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (targetSum == 0) return result;
        ArrayList<Integer> path = new ArrayList<>();

        dfs(root, targetSum, path);

        return result;
    }

    private void dfs(TreeNode root, int targetSum, ArrayList<Integer> path) {
        if (root == null) return;
        if (targetSum - root.val == 0 && root.left == null && root.right == null) {
            ArrayList<Integer> list = new ArrayList<>(path);
            list.add(root.val);
            result.add(list);
            return;
        }

        path.add(root.val);
        dfs(root.left, targetSum - root.val, path);
        dfs(root.right, targetSum - root.val, path);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2);
        TreeNode right = new TreeNode(-3);
        root.right = right;

        Solution solution = new Solution();
        List<List<Integer>> lists = solution.pathSum(root, -5);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }
    }
}
