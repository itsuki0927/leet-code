/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var searchInsert = function (nums, target) {
    let index = nums.indexOf(target);
    if (index == -1) {
        let ind = nums.findIndex(v => v > target);
        index = ind == -1 ? nums.length : ind;
    }
    return index;
};

console.log(searchInsert([1, 3, 5, 6], 2));