/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * 解题思路: 使用双指针
 *
 * @param {ListNode} head
 * @param {number} val
 * @return {ListNode}
 */
var deleteNode = function (head, val) {
  if (head.val === val) return head.next
  let prev = head,
    current = head.next
  while (current != null && current.val != val) {
    prev = current
    current = current.next
  }
  if (current != null) prev.next = current.next
  return head
}
