/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var mergeTwoLists = function(l1, l2) {
  const head = new ListNode(-1)
  let prev = head
  while (l1 && l2) {
    if (l1.val > l2.val) {
      prev.next = l1
      l1 = l1.next
    } else {
      prev.next = l2
      l2 = l2.next
    }
    prev = prev.next
  }
  prev.next = l1 ? l1 : l2

  return head.next
}

// 迭代方式
// var mergeTwoLists = function(l1, l2) {
//   if (l1 === null) {
//     return l2
//   } else if (l2 === null) {
//     return l1
//   } else if (l1.val < l2.val) {
//     l1.next = mergeTwoLists(l1.next, l2)
//     return l1
//   } else {
//     l2.next = mergeTwoLists(l1, l2.next)
//     return l2
//   }
// }
