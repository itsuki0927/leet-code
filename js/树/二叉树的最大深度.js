/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var maxDepth = function(root) {
  if (root === null) return 0

  if (root.left === null && root.right === null) return 1

  const d1 = maxDepth(root.left)
  const d2 = maxDepth(root.right)

  return Math.max(d1, d2) + 1
}
