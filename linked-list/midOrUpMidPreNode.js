// 奇数个返回中点, 偶数个返回上中点的前一个
const midOrUpMidPreNode = head => {
  if (head == null || head.next == null || head.next.next == null) return head
  let slow = head,
    fast = head.next.next
  while (fast.next != null && fast.next.next != null) {
    slow = slow.next
    fast = fast.next.next
  }
  return slow
}
