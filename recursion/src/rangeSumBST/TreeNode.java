package rangeSumBST;

/**
 * @module: mall-
 * @description:
 * @author: itsuki
 * @create: 2021-06-12 15:02
 **/
public class TreeNode {
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
