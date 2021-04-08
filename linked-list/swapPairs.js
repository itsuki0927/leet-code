/**
 * 解题思路: 直接交换两个节点的值即可
 *
 * @param {ListNode} head
 * @return {ListNode}
 */
var swapPairs = function (head) {
  if (head == null || head.next == null) return head

  let current = head
  while (current != null && current.next != null) {
    const prevVal = current.val
    const next = current.next.next
    current.val = current.next.val
    current.next.val = prevVal
    current = next
  }

  return head
}

// 解题思路: 头插法
var swapPairs = function (head) {
  if (head == null || head.next == null) return head
  const fake = new ListNode(-1, head)
  let current = head,
    pre = fake

  while (current != null && current.next != null) {
    // 保存后面的链表
    const next = current.next.next
    // 需要移动的节点
    const move = current.next
    // 将当前的节点连接到后面的链表
    current.next = next
    // 前指针连接移动节点
    pre.next = move
    // 移动节点指针指向当前节点, 也就是把链表串起来 
    move.next = current
    // 及时的更新前指针
    pre = current
    // 往后移动
    current = next
  }

  return fake.next
}

// 解题思路: 两两交换节点
var swapPairs = function (head) {
  const fake = new ListNode(-1, head)
  let current = fake

  while(current.next != null && current.next.next != null){
    const node1 = current.next
    const node2 = current.next.next
    current.next = node2
    node1.next = node2.next
    node2.next = node1
    current = node1
  }

  return fake.next
}

// TODO: 递归
