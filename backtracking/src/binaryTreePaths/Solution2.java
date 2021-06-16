package binaryTreePaths;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: itsuki
 * @create: 2021-06-16 10:32
 **/
public class Solution2 {
    List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> path = new ArrayList<>();
        dfs(root, path);
        return result;
    }

    private void dfs(TreeNode root, List<String> path) {
        if (root == null) return;
        path.add(root.val + "");
        if (root.left == null && root.right == null) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String s : path) {
                stringBuilder.append(s).append("->");
            }
            stringBuilder.delete(stringBuilder.lastIndexOf("->"), stringBuilder.length());
            result.add(stringBuilder.toString());
            return;
        }

        if (root.left != null) {
            dfs(root.left, path);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            dfs(root.right, path);
            path.remove(path.size() - 1);
        }
    }
}
