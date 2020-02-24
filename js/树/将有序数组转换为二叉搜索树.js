/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 *
 * 思路: 使用二分查找,因为数组是有序的,所以中间的数就是每一颗子树的根结点, 然后从 left 到 mid-1 构建左子树, mid+1 到 right构建右子树
 *
 * @param {number[]} nums
 * @return {TreeNode}
 */
var sortedArrayToBST = function(nums) {
  if (!nums.length) return null
  return create(nums, 0, nums.length - 1)
}

var create = function(nums, left, right) {
  if (left > right) return null

  const mid = left + Math.floor((right - left) / 2)
  const root = new TreeNode(nums[mid])
  root.left = create(nums, left, mid - 1)
  root.right = create(nums, mid + 1, right)
  return root
}
