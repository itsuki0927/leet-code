const merge = (arr, l, m, r) => {
  const help = []
  let i = 0,
    p1 = l,
    p2 = m + 1,
    ret = 0
    
  while (p1 <= m && p2 <= r) {
    if (arr[p1] > 2 * arr[p2]) {
      ret += m - p1 + 1
      p2++
    } else {
      p1++
    }
  }

  p1 = l
  p2 = m + 1
  while (p1 <= m && p2 <= r) help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++]
  while (p1 <= m) help[i++] = arr[p1++]
  while (p2 <= r) help[i++] = arr[p2++]
  for (let j = 0; j < help.length; j++) arr[l + j] = help[j]

  return ret
}

const mergeSort = (arr, l, r) => {
  if (l === r) return 0

  const mid = l + Math.floor((r - l) >> 1)
  return mergeSort(arr, l, mid) + mergeSort(arr, mid + 1, r) + merge(arr, l, mid, r)
}

/**
 * @param {number[]} nums
 * @return {number}
 */
var reversePairs = function (nums) {
  if (nums.length <= 1) return 0
  return mergeSort(nums, 0, nums.length - 1)
}
