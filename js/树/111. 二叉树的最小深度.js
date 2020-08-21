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
// dfs
var minDepth = function (root) {
  if (root === null) return 0
  if (root.left === null && root.right === null) return 1

  let result = Number.MAX_VALUE
  const dfs = (node, depth) => {
    if (node === null) return
    if (node.left === null && node.right === null) {
      result = Math.min(depth, result)
      return
    }
    dfs(node.left, depth + 1)
    dfs(node.right, depth + 1)
  }
  dfs(root, 1)
  return result
}

// dfs
var minDepth = function (root) {
  // 根结点为空
  if (root === null) return 0
  // 如果是叶子结点 则返回当前节点
  if (root.left === null && root.right === null) return 1

  const m1 = minDepth(root.left)
  const m2 = minDepth(root.right)

  //这里其中一个节点为空，说明m1和m2有一个必然为0，所以可以返回m1 + m2 + 1;
  if (root.left === null || root.right === null) return m1 + m2 + 1

  return Math.min(m1, m2) + 1
}

// bfs
var minDepth = function (root) {
  if (root === null) return 0
  const queue = [root]
  let ans = 1
  while (queue.length) {
    let len = queue.length
    for (; len--; ) {
      const node = queue.shift()
      if (node.left) queue.push(node.left)
      if (node.right) queue.push(node.right)
      if (node.left === null && node.right === null) return ans
    }
    ans++
  }
  return ans
}
