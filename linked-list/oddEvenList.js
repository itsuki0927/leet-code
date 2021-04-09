/**
 * 解题思路: 一分为二, 然后连接起来即可
 * @param {ListNode} head
 * @return {ListNode}
 */
var oddEvenList = function (head) {
  if(head == null) return head
  let odd = head,even = odd.next
  const evenHead = even
  while(even != null && even.next != null){
    odd.next = even.next
    odd = odd.next
    even.next = odd.next
    even = even.next
  }
  odd.next = evenHead
  return head
}
