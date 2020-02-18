/**
 *
 * 贪心算法
 *
 * 维护一个delta值，表示当前左括号的数量：
 * 如果delta < 0，表示当前有右括号未匹配，则必须添加一个左括号来跟它配对，因为即使后面有左括号也无法跟该右括号匹配。
 * 如果delta >= 0，表示当前有左括号未匹配，此时不需要马上添加右括号来跟它配对，因为后面可能会出现右括号。所以我们只需要在最后把delta算上就行。
 *
 * @param {string} S
 * @return {number}
 */
var minAddToMakeValid = function(S) {
  let ans = 0,
    delta = 0
  for (let i = 0, len = S.length; i < len; ++i) {
    delta += S[i] == '(' ? 1 : -1
    // 当前右括号更多，必须添加1个左括号
    if (delta == -1) {
      ans++
      delta++
    }
  }

  return ans + delta
}
// var minAddToMakeValid = function(S) {
//   const stack = []
//   for (let i = 0, len = S.length; i < len; i++) {
//     const el = S[i]
//     if (el === '(') {
//       stack.push(el)
//     } else if (el === ')' && stack[stack.length - 1] === '(') {
//       stack.pop()
//     } else {
//       stack.push(el)
//     }
//   }
//   console.log(stack)

//   return stack.length
// }

console.log(minAddToMakeValid('()))(('))
