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
var sumNumbers = function(root) {
  let sum = 0

  const getSum = function(root, k) {
    if (root === null) return
    const { val, left, right } = root

    k = k * 10 + val

    if (left === null && right === null) {
      sum += k
    }

    getSum(left, k)
    getSum(right, k)
  }

  getSum(root, 0)
  return sum
}
