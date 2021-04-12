/**
 * 解题思路: 模仿加法运算即可
 *
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function (l1, l2) {
  const fake = new ListNode(-1)
  let current = fake
  let carry = 0

  while (l1 != null || l2 != null) {
    const num1 = l1 == null ? 0 : l1.val
    const num2 = l2 == null ? 0 : l2.val
    const val = num1 + num2 + carry
    carry = Math.floor(val / 10)

    current.next = new ListNode(val % 10)

    l1 = l1 == null ? null : l1.next
    l2 = l2 == null ? null : l2.next
    current = current.next
  }

  if (carry) {
    current.next = new ListNode(carry)
  }

  return fake.next
}
