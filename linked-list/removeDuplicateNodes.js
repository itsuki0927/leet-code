/**
 * 解题思路: 利用哈希表
 *
 * @param {ListNode} head
 * @return {ListNode}
 */
var removeDuplicateNodes = function (head) {
  const fake = new ListNode(-1)
  fake.next = head
  let slow = fake,
    fast = head
  const map = {}

  while (fast != null) {
    const val = fast.val
    if (!map[val]) {
      map[val] = true
      slow = slow.next
    } else {
      slow.next = fast.next
    }
    fast = fast.next
  }

  return fake.next
}
