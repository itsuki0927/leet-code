/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */

const recur = root => {
  if (root == null) return 0
  const left = recur(root.left)
  if (left == -1) return -1
  const right = recur(root.right)
  if (right == -1) return -1
  return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1
}

const depth = root => {
  if (root == null) return 0
  return Math.max(depth(root.left), depth(root.right)) + 1
}

var isBalanced = function (root) {
  // if (root == null) return true
  // return (
  //   Math.abs(depth(root.left) - depth(root.right)) <= 1 &&
  //   isBalanced(root.left) &&
  //   isBalanced(root.right)
  // )
  return recur(root) != -1
}
