/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {ListNode} head
 * @return {TreeNode}
 */
var sortedListToBST = function (head) {
  // 快慢指针找到链表的中点，中点作为根结点，两边作为左右子树
  if (head == null) return null
  if (head.next == null) return new TreeNode(head.val)
  // 快慢指针找中间结点
  let fast = head,
    slow = head,
    pre = null
  while (fast != null && fast.next != null) {
    fast = fast.next.next
    pre = slow
    slow = slow.next
  }
  // 分割出左链表，用于构造本结点的左子树
  pre.next = null
  // 分割出右链表，用于构造本结点的右子树
  const rightList = slow.next
  // 用中间结点构造根结点
  const root = new TreeNode(slow.val)
  // 构造左子树
  root.left = sortedListToBST(head)
  // 构造右子树
  root.right = sortedListToBST(rightList)
  // 返回本结点所在子树
  return root
}
