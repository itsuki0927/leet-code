/**
 * @param {string} s
 * @return {number}
 *
 * 算出连续数字的数量 然后俩俩比较最小值相加
 * 110001100 -> 2322 -> 2 + 2 + 2 = 6
 */
var countBinarySubstrings = function (s) {
  let result = 0
  let cur = 1
  let pre = 0
  for (let i = 0; i < s.length - 1; i++) {
    if (s[i] === s[i + 1]) {
      // 计算当前数字数量
      cur++
    } else {
      // 将当前数字数量保存在一个变量
      pre = cur
      // 重置计算器
      cur = 1
    }
    // 如果大于
    if (pre >= cur) {
      result++
    }
  }
  return result
}

/**
 * @param {string} s
 * @return {number}
 */
var countBinarySubstrings2 = function (s) {
  let result = 0
  let cur = 1
  let last = 0
  for (let i = 0; i < s.length; i++) {
    if (s[i] === s[i + 1]) {
      cur++
    } else {
      result += Math.min(cur, last)
      last = cur
      cur = 1
    }
  }
  return result
}

countBinarySubstrings('00110011')
