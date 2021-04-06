/**
 * 解题思路: 归并排序
 *
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var mergeTwoLists = function (l1, l2) {
  const fake = new ListNode(-1)
  let temp = fake
  while (l1 !== null && l2 !== null) {
    if (l1.val <= l2.val) {
      temp.next = l1
      l1 = l1.next
    } else {
      temp.next = l2
      l2 = l2.next
    }
    temp = temp.next
  }

  temp.next = l1 ? l1 : l2

  return fake.next
}
