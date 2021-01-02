/**
 * @param {number[]} nums
 * @return {number}
 */
var missingNumber = function (nums) {
  let l = 0,
    r = nums.length - 1

  while (l < r) {
    const mid = l + Math.floor((r - l) / 2)
    if (nums[mid] != mid) r = mid
    else l = mid + 1
  }

  return l === nums.length - 1 && nums[l] === l ? l + 1 : l
}
