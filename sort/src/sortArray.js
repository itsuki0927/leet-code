const swap = (arr, i, j) => {
  const num = arr[i]
  arr[i] = arr[j]
  arr[j] = num
}

const partition = (arr, l, r) => {
  let less = l - 1,
    more = r
  const povit = arr[r]
  while (l < more) {
    if (arr[l] > povit) {
      swap(arr, l, --more)
    } else if (arr[l] < povit) {
      swap(arr, l++, ++less)
    } else {
      l++
    }
  }
  swap(arr, more, r)
  return [less + 1, more]
}

const quickSort = (arr, l, r) => {
  if (l < r) {
    swap(arr, l + Math.floor(Math.random() * (r - l + 1)), r)
    const [less, more] = partition(arr, l, r)
    quickSort(arr, l, less - 1)
    quickSort(arr, more + 1, r)
  }
}
/**
 * 解题思路: 快速排序
 *
 * @param {number[]} nums
 * @return {number[]}
 */
var sortArray = function (nums) {
  const length = nums.length
  if (length <= 1) return nums
  quickSort(nums, 0, length - 1)
  return nums
}

// TODO: 其他排序
