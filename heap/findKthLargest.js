const swap = (arr, i, j) => {
  const num = arr[i]
  arr[i] = arr[j]
  arr[j] = num
}

const heapInsert = (arr, index) => {
  while (arr[index] > arr[(index - 1) >> 1]) {
    swap(arr, index, (index - 1) >> 1)
    index = (index - 1) >> 1
  }
}

const heapify = (arr, index, size) => {
  let left = index * 2 + 1
  let largest

  while (left < size) {
    largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left

    largest = arr[index] > arr[largest] ? index : largest
    if (index === largest) break

    swap(arr, index, largest)

    index = largest
    left = index * 2 + 1
  }
}

/**
 * 暴力破解: 使用堆排序, 然后读取下标
 *
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findKthLargest = function (nums, k) {
  let heapSize = nums.length
  if (nums == null || heapSize < 2) return nums[k - 1]
  for (let i = 0; i < heapSize; i++) heapInsert(nums, i)

  swap(nums, 0, --heapSize)
  while (heapSize) {
    heapify(nums, 0, heapSize)
    swap(nums, 0, --heapSize)
  }
  return nums[nums.length - k]
}

/**
 * 解题思路: 构建大顶堆, 然后移除k-1个元素即可
 *
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findKthLargest = function (nums, k) {
  let heapSize = nums.length
  const size = heapSize

  // 构建大顶堆
  for (let i = 0; i < size; i++) heapInsert(nums, i)

  // 移除第k-1个元素
  for (let i = size - 1; i > size - k; i--) {
    swap(nums, 0, i)
    heapify(nums, 0, --heapSize)
  }
  // 第0个元素就是第k大元素
  return nums[0]
}
