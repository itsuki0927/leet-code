package maxDepth;

/**
 * @author: itsuki
 * @create: 2021-04-26 20:20
 **/
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }
}
