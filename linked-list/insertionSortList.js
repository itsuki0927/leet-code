/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var insertionSortList = function (head) {
  if (head == null) return head

  const fake = new ListNode(-1, head)
  let lastSorted = head,
    current = head.next
  while (current != null) {
    const val = current.val
    // 如果小于的话不需要进行插入排序, 只需要更新最后排序的位置即可
    if (lastSorted.val <= val) {
      lastSorted = current
    } else {
      // 找到插入的位置
      let prev = fake
      while (prev.next.val <= val) {
        prev = prev.next
      }
      // 进行插入排序
      lastSorted.next = current.next
      current.next = prev.next
      prev.next = current
    }
    // 往后移一位
    current = lastSorted.next
  }
  return fake.next
}
