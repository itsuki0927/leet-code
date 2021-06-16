package binaryTreePaths;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: itsuki
 * @create: 2021-06-16 10:32
 **/
public class Solution {
    List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "");
        return result;
    }

    private void dfs(TreeNode root, String path) {
        if (root == null) return;
        path += root.val;
        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }

        dfs(root.left, path + "->");
        dfs(root.right, path + "->");
    }
}
