// 奇数个返回中点, 偶数个返回下中点
const midOrDownMidNode = head => {
  if (head == null || head.next == null) return head
  let slow = head.next,
    fast = head.next
  while (fast.next != null && fast.next.next != null) {
    slow = slow.next
    fast = fast.next.next
  }
  return slow
}
