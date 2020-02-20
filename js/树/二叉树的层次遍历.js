/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * 将每一次传入的队列大小记录下来就可以得到当前层的节点个数，树的层次就可以很容易地被识别出来。
 *
 * @param {TreeNode} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
  const queue = [root]
  const result = []
  while (queue.length) {
    let length = queue.length
    const list = []
    while (length--) {
      const node = queue.shift()
      if (node != null) {
        list.push(node.val)
        const { left, right } = node
        if (left) queue.push(left)
        if (right) queue.push(right)
      }
    }
    result.push(list)
  }

  return result
}
