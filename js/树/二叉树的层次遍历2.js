/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 *
 * 递归实现
 *
 * @param {TreeNode} root
 * @return {number[][]}
 */
var levelOrderBottom = function(root) {
  const result = []
  levelOrderBottom2(root, 0, result)
  return result
}

var levelOrderBottom2 = function(root, level, list) {
  if (root === null) return
  const { left, right, val } = root
  if (list.length <= level) list.unshift([])
  list[list.length - level - 1].push(val)

  levelOrderBottom2(left, level + 1, list)
  levelOrderBottom2(right, level + 1, list)
}

/**
 *
 * 使用队列得到顺序的层次遍历,然后进行反转
 *
 */
var levelOrderBottom = function(root) {
  if (root === null) return []
  const result = []
  const queue = [root]
  while (queue.length) {
    let { length } = queue
    const list = []
    while (length) {
      const { val, left, right } = queue.shift()
      list.push(val)
      if (left) queue.push(left)
      if (right) queue.push(right)
      length--
    }

    result.push(list)
  }
  return result.reverse()
}
