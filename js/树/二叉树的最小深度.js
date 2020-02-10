/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 *
 * 广度搜索
 *
 * @param {TreeNode} root
 * @return {number}
 */
var minDepth = function(root) {
  // 根结点为空
  if (root === null) return 0
  let ans = 1
  let list = [root]
  while (list.length) {
    let len = list.length
    for (; len--; ) {
      root = list.shift()
      const { left, right } = root
      if (left) list.push(left)
      if (right) list.push(right)
      if (left === null && right === null) return ans
    }
    ans++
  }
  return ans
}

/**
 *
 * 深度搜索
 *
 */
var minDepth2 = function(root) {
  // 根结点为空
  if (root === null) return 0
  // 如果是叶子结点 则返回当前节点
  if (root.left === null && root.right === null) return 1

  const m1 = minDepth(root.left)
  const m2 = minDepth(root.right)

  if (root.left === null || root.right === null) return m1 + m2 + 1

  return Math.min(m1, m2) + 1
}
