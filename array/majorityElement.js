/**
 * 暴力破解
 *
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement2 = function (nums) {
  if (nums == null || nums.length == 0) return -1
  const length = nums.length
  const mid = length >> 1
  const map = {}

  for (let i = 0; i < length; i++) {
    map[nums[i]] = (map[nums[i]] || 0) + 1
  }

  for (const key of Object.keys(map)) {
    if (map[key] > mid) return +key
  }
  return -1
}

/**
 * 摩尔投票法
 *
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function (nums) {
  if (nums == null) return -1
  const { length } = nums
  let count = 0,
    major = 0
  // 对抗阶段: 分属两个候选人的票数进行两两对抗抵消
  for (let i = 0; i < length; i++) {
    if (count === 0) major = nums[i]
    if (major === nums[i]) count++
    else count--
  }

  // 计数阶段:
  count = 0
  for (let num of nums) {
    if (num === major) {
      count++
    }
  }

  return count > length / 2 ? major : -1
}

console.log(majorityElement([1, 2, 5, 9, 5, 9, 5, 5, 5]))
console.log(majorityElement([1, 2, 3]))
console.log(majorityElement([2, 2, 1, 1, 1, 2, 2]))
