/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * 快慢指针
 *
 * 快指针每次往前多走一步, 如果出现环形的话, 快指针 == 慢指针, 快慢指针必定会相遇
 *
 * @param {ListNode} head
 * @return {boolean}
 */
var hasCycle = function(head) {
  if (head == null || head.next == null) {
    return false
  }
  let slow = head
  let fast = head.next
  while (slow != fast) {
    if (slow == null || fast == null || fast.next == null) {
      return false
    }
    slow = slow.next
    fast = fast.next.next
  }

  return true
}

/**
 * 哈希表思路
 *
 */
var hasCycle2 = function(head) {
  const set = new Set()
  while (head) {
    if (set.has(head)) {
      return true
    }
    set.add(head)
    head = head.next
  }
  return false
}
