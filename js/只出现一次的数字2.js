/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function (nums) {
    let sum = [...new Set(nums)].reduce((acc, val) => (acc + val));
    let originSum = nums.reduce((acc, val) => (acc + val));
    return ((sum * 3) - originSum) / 2;
};

console.log(singleNumber([0, 1, 0, 1, 0, 1, 2, 99, 99, 99])) // 1 + 99 +2