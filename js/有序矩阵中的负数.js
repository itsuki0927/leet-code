/**
 * @param {number[][]} grid
 * @return {number}
 */
var countNegatives = function (grid) {
  let count = 0

  for (const item of grid) {
    if (item[0] < 0) {
      count += item.length
      continue
    }
    for (let inx = 0; inx < item.length; inx++) {
      const num = item[inx]
      if (num < 0) {
        count += item.length - inx
        break
      }
    }
  }
  return count
}
