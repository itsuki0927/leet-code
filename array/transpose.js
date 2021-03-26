/**
 * @param {number[][]} matrix
 * @return {number[][]}
 */
var transpose = function (matrix) {
  if (matrix == null) return [[]]
  const row = matrix.length
  const col = matrix[0].length
  const ret = Array.from({ length: col }, () => Array.from({ length: row }, () => 0))
  for (let i = 0; i < row; i++) {
    for (let j = 0; j < col; j++) {
      ret[j][i] = matrix[i][j]
    }
  }
  return ret
}

transpose([
  [1, 2, 3],
  [4, 5, 6],
])
