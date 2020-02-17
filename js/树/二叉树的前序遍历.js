/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var preorderTraversal = function(root) {
  if (root === null) return []
  const stack = [root]
  const result = []
  while (stack.length) {
    const curr = stack.pop()
    const { left, right } = curr
    result.push(curr.val)
    if (right) stack.push(right)
    if (left) stack.push(left)
  }
  return result
}
