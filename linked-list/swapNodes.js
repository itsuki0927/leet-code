/**
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */
var swapNodes = function (head, k) {
  const fake = new ListNode(-1, head)
  let tar1 = fake,
    tar2 = head,
    fast = head

  while (--k) {
    fast = fast.next
  }
  tar1 = fast
  while (fast.next != null) {
    fast = fast.next
    tar2 = tar2.next
  }
  const num = tar1.val
  tar1.val = tar2.val
  tar2.val = num

  return fake.next
}
