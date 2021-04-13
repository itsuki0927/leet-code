const swap = (arr, i, j) => {
  const num = arr[i]
  arr[i] = arr[j]
  arr[j] = num
}
/**
 * 解题思路: 经典的荷兰国旗问题, 维护两个指针, 一个指针用来扩展小于1的区域, 一个指针用来扩展大于1的区域
 *
 * @param {number[]} nums
 * @return {number[]}
 */
var sortColors = function (nums) {
  // 小于指针
  let less = -1,
    // 大于指针
    more = nums.length,
    i = 0
  while (i < more) {
    // 如果大于1
    if (nums[i] > 1) {
      // 交换i和more-1位置的值,并且扩大more区域
      // 不需要往后移动i, 因为交换值之后需要再次判断i
      swap(nums, i, --more)
    } else if (nums[i] < 1) {
      // 交换i和less+1位置的值,并且扩大less区域
      swap(nums, i++, ++less)
    } else {
      // 等于直接后移
      i++
    }
  }
  return nums
}
