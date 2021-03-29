/**
 * 解题思路: 快慢指针, 先让快指针走k步, 然后快慢指针同时往后走, 快指针走到null时, 慢指针就是要找的倒数第k个节点
 * @param {ListNode} head
 * @param {number} k
 * @return {number}
 */
var kthToLast = function (head, k) {
  const fake = new ListNode(-1)
  fake.next = head
  const temp = fake.next
  let fast = temp,
    slow = temp
  while (k--) {
    fast = fast.next
  }
  while (fast != null) {
    slow = slow.next
    fast = fast.next
  }
  return slow.val
}

// 解题思路: 先放入数组, 然后通过下标读取
var kthToLast = function (head, k) {
  const list = []
  while (head != null) {
    list.push(head.val)
    head = head.next
  }
  return list[list.length - k]
}
