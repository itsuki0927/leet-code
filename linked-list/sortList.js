/**
 * 解题思路: 归并排序
 *
 * @param {ListNode} head
 * @return {ListNode}
 */
var sortList = function (head) {
  return sort(head)
}

var sort = function (head) {
  if (head == null || head.next == null) return head
  let fast = head.next.next,
    slow = head,
    pre = null

  while (fast !== null && fast.next !== null) {
    pre = slow
    fast = fast.next.next
    slow = slow.next
  }

  pre.next = null
  const l = sort(head)
  const r = sort(slow)
  return merge(l, r)
}

var merge = function (left, right) {
  const fake = new ListNode(-1)
  let temp = fake
  while (left && right) {
    if (left.val <= right.val) {
      temp.next = left
      left = left.next
    } else {
      temp.next = right
      right = right.next
    }
    temp = temp.next
  }
  temp.next = left ? left : right

  return fake.next
}
