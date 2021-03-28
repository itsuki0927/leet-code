/**
 * 解题思路: 使用双指针, 找到要删除元素的前一个位置, 然后删除(prev.next -> current.next)
 *
 * @param {ListNode} head
 * @param {number} val
 * @return {ListNode}
 */
var deleteNode = function (head, val) {
  if (head.val === val) return head.next
  let prev = head,
    current = head.next
  while (current != null && current.val != val) {
    prev = current
    current = current.next
  }
  if (current != null) prev.next = current.next
  return head
}

// 解题思路: 添加一个虚拟头节点
var deleteNode = function (head, val) {
  const fake = new ListNode(-1)
  fake.next = head
  let current = fake
  while (current.next != null) {
    if (current.next.val == val) {
      current.next = current.next.next
      break
    } else {
      current = current.next
    }
  }
  return fake.next
}

// 使用递归
var deleteNode = function (head, val) {
  if (head == null) return null
  if (head.val == val) return head.next
  head.next = deleteNode(head.next, val)
  return head
}
