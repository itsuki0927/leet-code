/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} headA
 * @param {ListNode} headB
 * @return {ListNode}
 */
var getIntersectionNode = function(headA, headB) {
  /**
    定义两个指针, 第一轮让两个到达末尾的节点指向另一个链表的头部, 最后如果相遇则为交点(在第一轮移动中恰好抹除了长度差)
    两个指针等于移动了相同的距离, 有交点就返回, 无交点就是各走了两条指针的长度
  **/
  if (headA === null || headB === null) return null
  let h1 = headA,
    h2 = headB
  // 在这里第一轮体现在pA和pB第一次到达尾部会移向另一链表的表头, 而第二轮体现在如果pA或pB相交就返回交点, 不相交最后就是null==null
  while (h1 != h2) {
    h1 = h1 === null ? headB : h1.next
    h2 = h2 === null ? headA : h2.next
  }
  return h1
}
