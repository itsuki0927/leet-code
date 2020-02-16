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
var postorderTraversal = function(root) {
  if (root === null) return []
  const nums = []
  const stack = [root]
  let pre = null
  while (stack.length) {
    const curr = stack[stack.length - 1]
    const { left, right } = curr
    if ((left === null && right === null) || (pre !== null && (left === pre || right === pre))) {
      //如果当前结点左右子节点为空或上一个访问的结点为当前结点的子节点时，当前结点出栈
      nums.push(curr.val)
      pre = curr
      stack.pop()
    } else {
      if (right) stack.push(right)
      if (left) stack.push(left)
    }
  }
  return nums
}

var postorderTraversal2 = function(root) {
  if (root === null) return []
  const nums = []
  let stack = [root]
  while (stack.length) {
    const curr = stack.pop()
    if (curr.left) stack.push(curr.left)
    if (curr.right) stack.push(curr.right)
    nums.unshift(curr.val)
  }
  return nums
}
