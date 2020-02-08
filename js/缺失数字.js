/**
 * @param {number[]} nums
 * @return {number}
 */
var missingNumber = function (nums) {

    let originSum = 0;
    for (let i = 0; i <= nums.length - 1; i++) originSum += nums[i];
    return nums.length * (nums.length + 1) / 2 - originSum;
};

console.log(missingNumber([9, 6, 4, 2, 3, 5, 7, 0, 1]));