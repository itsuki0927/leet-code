/**
 * 解题思路: 找到反转未知的前驱节点、后继节点, 然后将链表反转, 最后进行连接即可
 *
 * @param {ListNode} head
 * @param {number} left
 * @param {number} right
 * @return {ListNode}
 */
var reverseBetween = function (head, left, right) {
  // 翻转长度
  let reverseLength = right - left + 1
  // 前驱头节点
  let prevHead = null,
    result = head
  // 将 head 移动 left-1 的位置
  while (head && --left) {
    // 记录 head 的前一个节点
    prevHead = head
    head = head.next
  }

  // 保存head, 也就是逆置后的尾部
  let tail = head,
    newHead = null
  // 进行反转
  while (head && reverseLength) {
    const next = head.next
    head.next = newHead
    newHead = head
    head = next
    reverseLength--
  }

  // 将逆置后的尾部指向链表的后一段连接
  tail.next = head

  // 如果有前置头节点表示不是头节点
  if (prevHead) {
    prevHead.next = newHead
  } else {
    result = newHead
  }

  return result
}

// 解题思路: 头插法, 找到 left 的前面一个节点 prev , 然后将后面 right-left 个节点插到 prev 的后面即可
var reverseBetween = function (head, left, right) {
  if (left === right) return head
  // 加入一个虚拟节点, 处理边界问题
  const fake = new ListNode(-1, head)
  let reverseLength = right - left + 1,
    prev = fake

  // 找到 left 的前面一个节点
  for (let i = 0; i < left - 1; i++) {
    prev = prev.next
  }
  let current = prev.next

  // 进行头插法
  while (--reverseLength) {
    const next = current.next
    current.next = next.next
    next.next = prev.next
    prev.next = next
  }

  return fake.next
}
