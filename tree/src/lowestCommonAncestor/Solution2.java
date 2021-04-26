package lowestCommonAncestor;

/**
 * @author: itsuki
 * @create: 2021-04-26 16:23
 **/
public class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        // 找到左孩子
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 找到右孩子
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 如果左右孩子都不为空, root就是公共祖先节点
        if (left != null && right != null) return root;
        // 左边不为空, 表示公共祖先节点是 left
        // 否则就是 right
        return left != null ? left : right;
    }
}
