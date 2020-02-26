/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 *
 * 1. p,q都在左子树（二者的值都小于根的值）
 * 2. p,q都在右子树 （二者的值都大于根的值）
 * 3. p,q分别在左右子树（此时最近公共祖先为root）
 *
 * @param {TreeNode} root
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */
var lowestCommonAncestor = function(root, p, q) {
  const { left, right, val } = root
  const pv = p.val,
    qv = q.val
  if (pv > val && qv > val) {
    return lowestCommonAncestor(right, p, q)
  } else if (pv < val && qv < val) {
    return lowestCommonAncestor(left, p, q)
  } else {
    return root
  }
}
