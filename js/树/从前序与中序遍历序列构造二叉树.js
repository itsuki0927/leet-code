/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {number[]} preorder
 * @param {number[]} inorder
 * @return {TreeNode}
 */
var buildTree = function(preorder, inorder) {
  if (!preorder.length || !inorder.length) return null
  const head = preorder[0]
  const pos = inorder.indexOf(head)
  const midLeft = inorder.slice(0, pos)
  const midRight = inorder.slice(pos + 1)

  const preLeft = preorder.slice(1, pos + 1)
  const preRight = preorder.slice(pos + 1)

  const node = new TreeNode(head)

  node.left = buildTree(preLeft, midLeft)
  node.right = buildTree(preRight, midRight)
  return node
}
