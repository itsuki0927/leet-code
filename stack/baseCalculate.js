/**
 * 解题思路: 将算式当成加法来运算, 然后用一个符号栈sign来记录每一次的操作的符号, 如果是+, sign为1,
 * 如果是-, sign为-1, 值*sign则表现为每一个小算式的结果保存到ret中,即可完成计算
 *
 * @param {string} s
 * @return {number}
 */
var calculate2 = function (s) {
  const operateStack = [1]
  const n = s.length
  let ret = 0,
    sign = 1,
    i = 0

  while (i < n) {
    if (s[i] === ' ') {
      i++
    } else if (s[i] === '+') {
      // +: sign = 1
      sign = operateStack[operateStack.length - 1]
      i++
    } else if (s[i] === '-') {
      // -: sign = -1 (对结果取反)
      sign = -operateStack[operateStack.length - 1]
      i++
    } else if (s[i] === '(') {
      // 保存(前面的符号
      operateStack.push(sign)
      i++
    } else if (s[i] === ')') {
      operateStack.pop()
      i++
    } else {
      // 读取数字
      let num = 0
      while (i < n && s[i] >= '0' && s[i] <= '9') {
        num = num * 10 + Number(s[i])
        i++
      }
      // 将每一个操作符*小算式结果与最终结果进行相加
      ret += sign * num
    }
  }
  return ret
}

// 双栈法
var calculate = function (s) {
  let ret = 0,
    sign = 1

  const n = s.length
  const numStack = [],
    optStack = []
  for (let i = 0; i < n; i++) {
    if (s[i] === ' ') {
      continue
    }
    if (s[i] === '+' || s[i] === '-') sign = s[i] === '+' ? 1 : -1
    else if (s[i] >= '0' && s[i] <= '9') {
      let num = Number(s[i])
      while (i < n - 1 && s[i + 1] >= '0' && s[i + 1] <= '9') {
        num = num * 10 + Number(s[++i])
      }
      ret += sign * num
    } else if (s[i] === '(') {
      numStack.push(ret)
      optStack.push(sign)
      ret = 0
      sign = 1
    } else ret = numStack.pop() + ret * optStack.pop()
  }
  return ret
}

console.log(calculate('(1+(4+5+2)-3)+(6+8)'))
