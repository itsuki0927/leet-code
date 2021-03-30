/**
 * 解题思路: A长度为a, B长度为b, 假设存在交叉点, 此时a->交叉点的距离为c, b->交叉点的距离为d,
 * 交叉之后的长度是一样的, 即 a-c = b-d, 所以a+d = b+c, A走完自己的再走B的路, B走完自己的再走A的路,
 * 如果有交叉点, 那么他们必然会遇见.
 *
 * @param {ListNode} headA
 * @param {ListNode} headB
 * @return {ListNode
 */
var getIntersectionNode = function (headA, headB) {
  let h1 = headA,
    h2 = headB

  while (h1 != h2) {
    h1 = h1 == null ? headB : h1.next
    h2 = h2 == null ? headA : h2.next
  }

  return h1
}
