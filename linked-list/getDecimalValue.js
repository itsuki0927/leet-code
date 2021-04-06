/**
 * 解题思路: 利用stack
 *
 * @param {ListNode} head
 * @return {number}
 */
var getDecimalValue = function (head) {
  const stack = []
  let ret = 0
  while (head != null) {
    stack.push(head.val)
    head = head.next
  }
  const length = stack.length - 1
  for (let i = 0; i <= length; i++) {
    const num = stack[i]
    ret += num == 1 ? Math.pow(2, length - i) : 0
  }
  return ret
}
