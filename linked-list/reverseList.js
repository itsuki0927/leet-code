/**
 * 解题思路: 利用双指针prev、current来反转
 *
 * @param {ListNode} head
 * @return {ListNode}
 */
var reverseList = function (head) {
  if (head == null) return null
  // 当前的上一个节点
  let prev = null,
    // 当前节点
    current = head
  while (current) {
    // 临时节点, 暂存当前节点的下一个节点
    const temp = current.next
    // 将当前节点指向前一个节点
    current.next = prev
    // 指针往后移
    prev = current
    current = temp
  }
  return prev
}

// 递归版
const reverse = (prev, current) => {
  if (current == null) return prev

  const next = current.next
  current.next = prev

  return reverse(current, next)
}
var reverseList = function (head) {
  return reverse(null, head)
}

// 递归版2
var reverseList = function (head) {
  if (head == null) return null
  if (head.next == null) return head

  const newHead = reverseList(head.next)
  // 将下一节点指向头节点
  head.next.next = head
  head.next = null

  return newHead
}
