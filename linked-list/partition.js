/**
 * 解题思路: 用两个链表分别存储大于或者小于x, 然后进行拼接即可
 *
 * @param {ListNode} head
 * @param {number} x
 * @return {ListNode}
 */
var partition = function (head, x) {
  let large = new ListNode(-1),
    small = new ListNode(-1)

  const largeHead = large,
    ret = small
  while (head != null) {
    const val = head.val
    if (val >= x) {
      large.next = head
      large = large.next
    } else {
      small.next = head
      small = small.next
    }
    head = head.next
  }

  large.next = null
  small.next = largeHead.next
  return ret.next
}
