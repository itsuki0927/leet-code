/**
 *  往前走a-1步, 找到第a-1个节点, 然后再走b-a+1步, 找到第b-1个节点, 最后连接即可
 *
 * @param {ListNode} list1
 * @param {number} a
 * @param {number} b
 * @param {ListNode} list2
 * @return {ListNode}
 */
var mergeInBetween = function (list1, a, b, list2) {
  let current = list1,
    length = b - a + 1
  // 往前走a-1步
  for (let i = 0; i < a - 1; i++) {
    current = current.next
  }
  // 保存前置节点
  const pre = current
  current = current.next
  // 走 b-a+1 步
  while (--length) {
    current = current.next
  }
  // 连接list2的头
  pre.next = list2
  let cur2 = list2
  while (cur2.next != null) {
    cur2 = cur2.next
  }
  // list2的尾连接后面的链表
  cur2.next = current.next
  return list1
}
