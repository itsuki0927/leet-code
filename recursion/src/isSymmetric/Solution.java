package isSymmetric;

/**
 * 解题思路: 递归
 *
 * @author: itsuki
 * @create: 2021-04-27 15:07
 **/
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return isSymmetricMain(root.left, root.right);
    }

    public boolean isSymmetricMain(TreeNode left, TreeNode right) {
        // 如果left不为空、right为空
        if (left != null && right == null) return false;
        // 如果left为空、right不为空
        if (left == null && right != null) return false;
        // 如果left、right都为空
        if (left == null && right == null) return true;

        return left.val == right.val && isSymmetricMain(left.left, right.right) && isSymmetricMain(left.right, right.left);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

