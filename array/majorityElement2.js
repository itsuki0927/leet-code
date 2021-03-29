/**
 * 解题思路: 摩尔投票法
 *
 * 如果至多选一个代表，那他的票数至少要超过一半（⌊ 1/2 ⌋）的票数；
 * 如果至多选两个代表，那他们的票数至少要超过 ⌊ 1/3 ⌋ 的票数；
 * 如果至多选m个代表，那他们的票数至少要超过 ⌊ 1/(m+1) ⌋ 的票数。
 */
var majorityElement = function (nums) {
  const ret = []
  const length = nums.length
  let count1 = 0,
    count2 = 0,
    major1 = null,
    major2 = null

  for (let i = 0; i < length; i++) {
    const num = nums[i]
    if (num == major1) {
      count1++
    } else if (num == major2) {
      count2++
    } else if (count1 == 0) {
      major1 = num
      count1++
    } else if (count2 == 0) {
      major2 = num
      count2++
    } else {
      count1--
      count2--
    }
  }

  ;(count1 = 0), (count2 = 0)
  for (let i = 0; i < length; i++) {
    const num = nums[i]
    if (major1 == num) {
      count1++
    } else if (major2 == num) {
      count2++
    }
  }

  const len = Math.floor(length / 3)
  if (count1 > len) {
    ret.push(major1)
  }
  if (count2 > len) {
    ret.push(major2)
  }
  return ret
}

console.log(majorityElement([1, 1, 1, 3, 3, 2, 2, 2]))
