package rangeSumBST;

/**
 * @author: itsuki
 * @create: 2021-06-12 15:01
 **/
public class Solution {
    int result = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        dfs(root, low, high);
        return result;
    }

    public void dfs(TreeNode root, int low, int high) {
        if (root == null) return;

        if (root.val >= low && root.val <= high) {
            result += root.val;
        }

        dfs(root.left, low, high);
        dfs(root.right, low, high);
    }
}
