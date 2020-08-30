/**
 * @param {string} digits
 * @return {string[]}
 */
function letterCombinations(digits) {
  if (!digits) return []
  const result = []
  const strLen = digits.length
  const map = {
    2: 'abc',
    3: 'def',
    4: 'ghi',
    5: 'jkl',
    6: 'mno',
    7: 'pqrs',
    8: 'tuv',
    9: 'wxyz',
  }

  const dfs = (str, index) => {
    if (str.length === strLen) {
      result.push(str)
      return
    }

    const letters = map[digits[index]]
    for (let i = 0; i < letters.length; i++) {
      str += letters[i]
      dfs(str, index + 1)
      str = str.substr(0, str.length - 1)
    }
  }
  dfs('', 0)
  return result
}

letterCombinations('23')
