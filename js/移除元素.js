/**
 * @param {number[]} nums
 * @param {number} val
 * @return {number}
 */
var removeElement = function (nums, val) {
    nums.sort();
    let start = nums.indexOf(val);
    let end = nums.lastIndexOf(val);
    if (start != -1 && end != -1)
        nums.splice(start, end - start + 1);
    return nums.length;
};

console.log(removeElement([10], 2));