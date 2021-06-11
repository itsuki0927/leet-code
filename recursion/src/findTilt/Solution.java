package findTilt;

/**
 * @author: itsuki
 * @create: 2021-06-11 10:37
 **/
public class Solution {
    private int sum = 0;

    public int findTilt(TreeNode root) {
        traverse(root);
        return sum;
    }

    public int traverse(TreeNode root) {
        if (root == null) return 0;

        int left = traverse(root.left);
        int right = traverse(root.right);
        sum += Math.abs(left - right);
        return left + right + root.val;
    }
}
