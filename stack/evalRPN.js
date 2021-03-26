/**
 * 解题思路: 当碰到一个操作符号的时候, 将数组中最末尾的两个pop, 进行计算, 然后再将结果push到数组中, 以此反复即可.
 *
 * @param {string[]} tokens
 * @return {number}
 */
var evalRPN = function (tokens) {
  const numStack = []
  const computedMap = {
    '+': (a, b) => a + b,
    '-': (a, b) => b - a,
    '*': (a, b) => a * b,
    '/': (a, b) => ~~(b / a),
  }

  for (let i = 0; i < tokens.length; i++) {
    const num = Number(tokens[i])
    if (isNaN(num)) {
      if (numStack.length >= 2) {
        const num1 = numStack.pop()
        const num2 = numStack.pop()
        numStack.push(computedMap[tokens[i]](num1, num2))
      }
    } else {
      numStack.push(num)
    }
  }
  return numStack[0]
}

console.log(evalRPN(['10', '6', '9', '3', '+', '-11', '*', '/', '*', '17', '+', '5', '+']))
