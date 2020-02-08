/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canJump = function (nums) {
    let index = 0;
    let len = nums.length;
    if (len === 1) return true;
    while (index < len) {
        if (!nums[index]) return false;
        index += nums[index];
    }
    return (index - nums[len - 1] + 1) === len ? true : false;
};

console.log(canJump([2, 3, 1, 0, 4]));