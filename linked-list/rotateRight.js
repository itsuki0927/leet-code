/**
 * 解题思路: 快慢指针, 先快指针走k步, 然后两个指针同时往后走, 快指针到达终点时, 慢指针就是尾, 慢指针的下一个节点就是头
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */
var rotateRight = function (head, k) {
  if (head == null || head.next == null) return
  let total = 0,
    temp = head
  while (temp != null) {
    temp = temp.next
    total++
  }
  k %= total
  if (k === 0) return head

  let slow = head,
    fast = head
  while (k--) fast = fast.next

  while (fast.next != null) {
    fast = fast.next
    slow = slow.next
  }

  fast.next = head
  head = slow.next
  slow.next = null

  return head
}

// 解题思路: 闭合成环, 然后找到尾部向前数第K个元素作为头，原来的头接到原来的尾上
var rotateRight = function (head, k) {
  if (head == null || head.next == null) return head

  let n = 1,
    temp = head

  while (temp.next != null) {
    temp = temp.next
    n++
  }
  k %= n
  temp.next = head

  let index = n - k - 1
  while (index--) head = head.next

  let newHead = head.next
  head.next = null
  return newHead
}
