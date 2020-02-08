/**
 * @param {number[]} nums
 * @return {number}
 */
var minMoves2 = function (nums) {
    let midIndex = Math.floor(nums.length / 2);
    nums.sort((a, b) => (a - b));
    let midNum = nums[midIndex];
    let min = 0;
    for (let i = 0, len = nums.length; i < len; i++) {
        min += Math.abs(nums[i] - midNum);
    }
    return min;
};

console.log(minMoves2([2, 1, 3]));