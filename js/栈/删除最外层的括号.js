/**
 * @param {string} S
 * @return {string}
 */
var removeOuterParentheses = function(S) {
  let result = ''
  let level = 0
  for (let i = 0, len = S.length; i < len; i++) {
    const c = S[i]
    // 由于括号的对称性，可以看出只要是左括号'('其值大于1就应该加入，右括号')'只要大于0就加入
    if (c == ')') --level
    if (level >= 1) result += c
    if (c == '(') ++level
  }
  return result
}
