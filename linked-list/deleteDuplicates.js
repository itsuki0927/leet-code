/**
 * 添加虚拟头节点, 然后往后走进行删除
 *
 * @param {ListNode} head
 * @return {ListNode}
 */
var deleteDuplicates = function (head) {
  if (!head) return head
  const fake = new ListNode(-1)
  fake.next = head
  let curr = fake

  while (curr.next && curr.next.next) {
    if (curr.next.val === curr.next.next.val) {
      const val = curr.next.val
      while (curr.next && curr.next.val === val) {
        curr.next = curr.next.next
      }
    } else {
      curr = curr.next
    }
  }

  return fake.next
}

// 解题思路: 双指针, 然后找到重复删除, 否则正常往后走
var deleteDuplicates = function (head) {
  const fake = new ListNode(-1, head)
  let next = head,
    prev = fake,
    flag = false

  while (head != null && head.next != null) {
    next = head.next
    // 找到重复的节点, 改变标志位
    while (next != null && head.val == next.val) {
      head = head.next
      next = next.next
      flag = true
    }
    // 如果有重复节点, 则删除掉
    if (flag) {
      prev.next = next
    } else {
      // 否则正常的向后走一步
      prev = prev.next
    }
    // 标志位重置
    flag = false
    head = head.next
  }
  return fake.next
}
