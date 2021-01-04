/**
 * @param {number[]} numbers
 * @return {number}
 */
var minArray = function (numbers) {
  let l = 0,
    r = numbers.length - 1

  while (l < r) {
    const mid = l + Math.floor((r - l) / 2)
    if (mid[r] > numbers[mid]) {
      r = mid
    } else if (mid[r] < numbers[mid]) {
      l = mid + 1
    } else r--
  }
  return numbers[l]
}
