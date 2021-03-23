/**
 * 解题思路: 模拟栈入栈出栈，如果stack栈顶和popped栈顶相同,
 * 则同时出站，否则入栈，如果栈为空，表示是一个合法的出栈顺序
 * @param {number[]} pushed
 * @param {number[]} popped
 * @return {boolean}
 */
var validateStackSequences = function (pushed, popped) {
  const stack = []
  let poppedIdx = 0
  if (!pushed.length || !popped.length) return true
  for (let i = 0; i < pushed.length; i++) {
    stack.push(pushed[i])
    // 判断stack栈顶与popped栈顶是不是相同
    while (stack.length && stack[stack.length - 1] === popped[poppedIdx]) {
      stack.pop()
      poppedIdx++
    }
  }
  return !stack.length
}
console.log(validateStackSequences([1, 2, 3, 4, 5], [4, 5, 3, 2, 1]))
