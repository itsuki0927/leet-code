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
var rightSideView = function(root) {
  if (root === null) return []
  const result = []
  const queue = [root]
  while (queue.length) {
    let { length } = queue

    while (length--) {
      const { left, right, val } = queue.shift()
      if (length === 0) {
        result.push(val)
      }
      if (left) queue.push(left)
      if (right) queue.push(right)
    }
  }
  return result
}
