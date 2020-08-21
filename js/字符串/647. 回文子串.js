/**
 * @param {string} s
 * @return {number}
 */

var countSubstrings = function (s) {
  let num = 0

  const count = (str, start, end) => {
    const { length } = str
    while (start >= 0 && end < length && str[start] === str[end]) {
      num++
      start--
      end++
    }
  }

  for (let i = 0; i < s.length; i++) {
    count(s, i, i)
    count(s, i, i + 1)
  }

  return num
}
