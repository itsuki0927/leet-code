// 奇数个返回中点, 偶数个返回下中点的前一个
const midOrDownMidPreNode = head => {
  if (head == null || head.next == null) return null
  if (head.next.next == null) return head
  let slow = head,
    fast = head.next
  while (fast.next != null && fast.next.next != null) {
    slow = slow.next
    fast = fast.next.next
  }
  return slow
}
