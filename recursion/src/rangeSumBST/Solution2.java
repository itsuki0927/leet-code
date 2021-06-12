package rangeSumBST;


/**
 * @author: itsuki
 * @create: 2021-06-12 15:01
 **/
public class Solution2 {

    // 二叉搜索树的特点为：若左子树不为空, 则左子树的所有结点都小于根节点; 若右子树不为空, 则右子树的所有结点都大于根节点。
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        if (low <= root.val && root.val <= high) {
            //当前节点在两数之间，把自身值加到结果里取，并往左右子节点递归
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        } else if (root.val < low) {
            // 当前节点小于L，往右子节点寻找
            return rangeSumBST(root.right, low, high);
        } else {
            // 当前节点小于R，往左子节点寻找
            return rangeSumBST(root.left, low, high);
        }
    }
}
