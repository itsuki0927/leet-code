// 解题思路: 快慢指针
var middleNode = function (head) {
  let slow = (fast = head)
  while (fast != null && fast.next != null) {
    fast = fast.next.next
    slow = slow.next
  }
  return slow
}

// 解题思路: 数组,遍历链表,然后存入数组, 最后数组[mid]
var middleNode = function (head) {
  let A = [head]
  while (A[A.length - 1].next != null) {
    A.push(A[A.length - 1].next)
  }
  return A[Math.trunc(A.length - 1) / 2]
}

// 解题思路: 单指针+两次遍历, 第一次统计数量, 第二次找到mid的位置返回
var middleNode = function (head) {
  let n = 0,
    p = (cur = head)
  while (p != null) {
    n++
    p = p.next
  }
  const mid = Math.trunc(n / 2)
  n = 0
  while (n < mid) {
    cur = cur.next
    n++
  }
  return cur
}
