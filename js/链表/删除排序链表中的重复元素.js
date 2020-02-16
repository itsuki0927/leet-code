/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var deleteDuplicates = function(head) {
  let header = head

  while (header && header.next) {
    if (header.val === header.next.val) {
      header.next = header.next.next
    } else header = header.next
  }
  return head
}
