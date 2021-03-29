/**
 * 解题思路: 添加虚拟节点(防止边界问题), 然后利用双指针实现
 *
 * @param {ListNode} head
 * @param {number} val
 * @return {ListNode}
 */
var removeElements = function (head, val) {
  const fake = new ListNode(-1)
  fake.next = head
  let current = head,
    prev = fake

  while (current != null) {
    if (current.val === val) {
      prev.next = current.next
    } else {
      prev = current
    }
    current = current.next
  }

  return fake.next
}

var removeElements = function (head, val) {
  if (head == null) return null
  head.next = removeElements(head.next, val)
  return head.val === val ? head.next : head
}
