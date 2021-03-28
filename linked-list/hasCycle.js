/**
 * 解题思路: 快慢指针, 快指针每次走两步, 慢指针每次走一步, 因为如果链表中有环, 快慢指针总会相遇
 * @param {ListNode} head
 * @return {boolean}
 */
var hasCycle = function (head) {
  if (head == null || head.next == null) return false

  let slow = head,
    fast = head.next
  // 如果快指针走完了, 说明没环
  while (fast != null && fast.next != null) {
    // 如果两个相遇了, 有环
    if (fast == slow) return true
    // 走两步
    fast = fast.next.next
    // 走一步
    slow = slow.next
  }
  return false
}

// 解题思路: 使用哈希表, 如果有重复表示有环
var hasCycle = function (head) {
  const map = new Map()

  while (head != null) {
    if (map.get(head)) {
      return true
    }
    map.set(head, head)
    head = head.next
  }
  return false
}
