/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function (s) {
  if (s.length % 2) return false
  const stack = []
  const map = {
    '{': '}',
    '[': ']',
    '(': ')',
  }
  for (let i = 0; i < s.length; i++) {
    const str = s[i]
    if (['(', '{', '['].includes(str)) {
      stack.push(map[str])
    } else if (!stack.length || str !== stack.pop()) {
      return false
    }
  }
  return !stack.length
}

console.log('label:', isValid('['))
