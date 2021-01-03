/**
 * @param {string[]} words
 * @param {string} s
 * @return {number}
 */
var findString = function (words, s) {
  let l = 0,
    r = words.length - 1

  while (l <= r) {
    // 过滤空串
    while (!words[l]) {
      l++
    }
    // 过滤空串
    while (!words[r]) {
      r--
    }
    let mid = l + Math.floor((r - l) / 2)
    while (mid >= l && !words[mid]) {
      mid--
    }

    if (words[mid] === s) return mid
    else if (words[mid] > s) r = mid - 1
    else l = mid + 1
  }

  return -1
}
