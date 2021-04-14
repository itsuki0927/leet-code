const merge = (arr, l, m, r) => {
  const help = []
  let i = 0,
    p1 = l,
    p2 = m + 1,
    ret = 0

  while (p1 <= m && p2 <= r) {
    // 在排序的时候进行判断, 然后进行累加
    ret += arr[p1] > arr[p2] ? m - p1 + 1 : 0
    // ret += arr[p2] < arr[p1] ? (p2 - m) : 0
    help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++]
  }

  while (p1 <= m) help[i++] = arr[p1++]
  while (p2 <= m) help[i++] = arr[p2++]
  for (let i = 0; i < help.length; i++) arr[l + i] = help[i]

  return ret
}

const mergeSort = (arr, l, r) => {
  if (l === r) return 0
  const mid = l + ((r - l) >> 1)

  return mergeSort(arr, l, mid) + mergeSort(arr, mid + 1, r) + merge(arr, l, mid, r)
}

/**
 * 解题思路: 归并排序, 在归并的时候判断当前元素是否大于后面的元素, 如果大于则进行累加(因为排序后数组是有序的),
 * 比如说: 5、6、7 和 1、2、3, 当5大于1时, 表示5后面的数都大于1, 所以可以直接(m-p1+1)进行累加即可
 *
 * @param {number[]} nums
 * @return {number}
 */
var reversePairs = function (nums) {
  if (nums.length < 2) return 0
  return mergeSort(nums, 0, nums.length - 1)
}

// 解题思路: 离散化树状数组
// TODO: code

// TODO: leetcode类似题目: 315、51、327、493
// 待做
