package invertTree;

/**
 * @author: itsuki
 * @create: 2021-04-28 20:34
 **/
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        swap(root.left, root.right);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    private void swap(TreeNode left, TreeNode right) {
        TreeNode temp = left;
        left = right;
        right = left;
    }
}
