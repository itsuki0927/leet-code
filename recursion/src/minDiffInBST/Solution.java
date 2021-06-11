package minDiffInBST;

/**
 * @author: itsuki
 * @create: 2021-06-11 10:59
 **/
public class Solution {
    TreeNode pre = null;
    int result = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return result;
    }

    private void dfs(TreeNode root) {
        // 边界条件判断
        if (root == null) return;
        // 递归遍历左子树
        dfs(root.left);
        // 记录当前节点和前一个节点的差值
        if (pre != null) {
            result = Math.min(result, root.val - pre.val);
        }
        // 当前节点遍历之后就变成了前一个节点
        pre = root;
        // 递归遍历右子树
        dfs(root.right);
    }
}
