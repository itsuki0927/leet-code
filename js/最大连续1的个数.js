/**
 * @param {number[]} nums
 * @return {number}
 */
var findMaxConsecutiveOnes = function (nums) {
    return Math.max(...nums.join('').split('0').map(v => v.length))
};

console.log(findMaxConsecutiveOnes([1, 1, 0, 0, 0, 0, 1, 1, 1]));