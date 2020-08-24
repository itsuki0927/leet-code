/**
 * @param {string} s
 * @return {boolean}
 */
var repeatedSubstringPattern = function (s) {
  // 去掉头和尾
  // 如果是重复出现的子串肯定会在`${s}${s}`字符串中再次出现
  return `${s}${s}`.substring(1, s.length * 2 - 1).indexOf(s) != -1
}

repeatedSubstringPattern('123123')
