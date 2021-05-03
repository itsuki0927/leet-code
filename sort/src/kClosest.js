const getDistanceToOrigin = arr => arr[0] * arr[0] + arr[1] * arr[1]

const swap = (arr, i, j) => {
  const temp = arr[i]
  arr[i] = arr[j]
  arr[j] = temp
}

const partition = (arr, l, r) => {
  let less = l - 1,
    more = r,
    pivot = getDistanceToOrigin(arr[r])
  while (l < more) {
    let sum = getDistanceToOrigin(arr[l])
    if (sum > pivot) {
      swap(arr, l, --more)
    } else if (sum < pivot) {
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
 * 解题思路: 根据平方和进行快速排序, 然后读取k个数即可
 *
 * @param {number[][]} points
 * @param {number} k
 * @return {number[][]}
 */
var kClosest = function (points, k) {
  quickSort(points, 0, points.length - 1)
  return points.slice(0, k)
}
