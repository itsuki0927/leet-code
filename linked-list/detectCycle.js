/**
 * 解题思路: 快慢指针, 快指针走两步, 慢指针走一步找到它们相交的节点, 然后快指针回到head从头开始, 快慢指针都只走一步, 两个相等就是第一个交点,否则就是null.
 *
 * @param {ListNode} head
 * @return {ListNode}
 */
var detectCycle = function (head) {
  if (head == null || head.next == null || head.next.next == null) return null
  let fast = head.next.next,
    slow = head.next
  while (fast != slow) {
    if (fast.next == null || fast.next.next == null) return null
    slow = slow.next
    fast = fast.next.next
  }
  fast = head
  while (fast != slow) {
    fast = fast.next
    slow = slow.next
  }
  return slow
}
