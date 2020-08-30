/**
 * @param {string} s
 * @return {string}
 */
var reverseWords = function (s) {
  return s
    .split(' ')
    .reduce((cur, str) => [...cur, str.split('').reverse().join('')], [])
    .join(' ')
}
var reverseWords = function (s) {
  let result = ''
  const list = []
  for (let i = 0; i < s.length; i++) {
    const str = s[i]
    if (str !== ' ') {
      list.unshift(str)
    } else {
      result += `${list.join('')} `
      list.length = 0
    }
  }
  if (list.length) {
    result += list.join('')
  }
  return result
}
var reverseWords = function (s) {
  const result = []
  const length = s.length
  let i = 0
  while (i < length) {
    const start = i
    while (i < length && s[i] != ' ') {
      i++
    }
    let p = start
    while (p < i) {
      result.push(s[start + i - 1 - p])
      p++
    }
    while (i < length && s[i] == ' ') {
      i++
      result.push(' ')
    }
  }
  return result.join('')
}
