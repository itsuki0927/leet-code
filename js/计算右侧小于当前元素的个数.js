/**
 * @param {number[]} nums
 * @return {number[]}
 * @description 困难的难度  后面再做
 */
var countSmaller = function (nums) {
    let list = [];
    for (let i = 0, len = nums.length; i < len; i++) {
        list.push(nums.slice(i).filter(v => nums[i] > v).length);
    }
    return list
};

console.log(countSmaller([5, 2, 6, 1]))