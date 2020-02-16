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
var inorderTraversal = function(root) {
  const nums = []
  const stack = []
  let curr = root
  while (stack.length || curr !== null) {
    while (curr !== null) {
      stack.push(curr)
      curr = curr.left
    }
    curr = stack.pop()
    nums.push(curr.val)
    curr = curr.right
  }

  return nums
}

// 使用递归
var inorderTraversal2 = function(root) {
  const nums = []
  const func = function(root) {
    if (root !== null) {
      func(root.left)
      nums.push(root.val)
      func(root.right)
    }
  }

  func(root)
  return nums
}
