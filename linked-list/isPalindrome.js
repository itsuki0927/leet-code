/**
 * 解题思路: 先把数值放入数组中, 然后头尾指针两两比较
 */
var isPalindrome = function (head) {
  const list = []
  while (head != null) {
    list.push(head.val)
    head = head.next
  }

  let s = 0,
    e = list.length - 1

  while (s < e) {
    if (list[s] != list[e]) return false
    s++
    e--
  }
  return true
}

/**
 * 解题思路: 快慢指针
 *
 * 1. 找到前半部分链表的尾节点。
 * 2. 反转后半部分链表。
 * 3. 判断是否回文。
 * 4. 恢复链表。
 * 5. 返回结果。
 *
 * 小技巧: 慢指针一次走一步，快指针一次走两步，快慢指针同时出发。当快指针移动到链表的末尾时，慢指针恰好到链表的中间
 */
var isPalindrome = function (head) {
  // 反转链表
  const reverseList = head => {
    let prev = null,
      current = head
    while (current != null) {
      const next = current.next
      current.next = prev
      prev = current
      current = next
    }
    return prev
  }

  // 找到中间位置
  const endOfFirstHalf = head => {
    let slow = head,
      fast = head

    while (fast != null && fast.next != null) {
      fast = fast.next.next
      slow = slow.next
    }

    return slow
  }

  // 运用虚拟节点, 避免判断head == null
  const fake = new ListNode(-1)
  fake.next = head
  const mid = endOfFirstHalf(head)
  let reversed = reverseList(mid)

  while (reversed != null) {
    if (head.val != reversed.val) return false

    head = head.next
    reversed = reversed.next
  }
  return true
}

// 简化版
var isPalindrome = function (head) {
  let fast = head,
    slow = head,
    pre = null
  while (fast) {
    slow = slow.next
    fast = fast.next ? fast.next.next : fast.next
  }

  while (slow) {
    let next = slow.next
    slow.next = pre
    pre = slow
    slow = next
  }

  while (head && pre) {
    if (head.val !== pre.val) return false
    head = head.next
    pre = pre.next
  }
  return true
}
