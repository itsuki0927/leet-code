/**
 * 解题思路: 寻找链表中点 + 逆序链表 + 合并链表
 *
 * @param {ListNode} head
 * @return {void} Do not return anything, modify head in-place instead.
 */

var reverseList = head => {
  let pre = null

  while (head != null) {
    const next = head.next
    head.next = pre
    pre = head
    head = next
  }

  return pre
}

var reorderList = function (head) {
  if (head == null || head.next == null) return head
  let ret = head,
    slow = head.next,
    fast = head.next.next
  while (fast != null && fast.next != null && fast.next.next != null) {
    slow = slow.next
    fast = fast.next.next
  }
  const _ = slow
  slow = slow.next
  // 切断链表
  _.next = null
  // 链表逆序
  slow = reverseList(slow)

  // 链表合并
  while (head != null && slow != null) {
    const next = head.next
    const slowNext = slow.next
    head.next = slow
    slow.next = next
    head = next
    slow = slowNext
  }

  return ret
}
