/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function (nums) {
    let i = 0;
    let count = 1;
    for (let j = 1, len = nums.length; j < len; j++) {
        if (nums[i] != nums[j]) {
            nums[++i] = nums[j];
            count = 1;
        } else if (count >= 2) {
            console.log(i, j);

            continue;
        } else {
            nums[++i] = nums[j];
            count++;
        }
    }
    nums.splice(i + 1, nums.length - i);
    console.log(nums);

    return i + 1;
};

console.log(removeDuplicates([0, 0, 1, 1, 1, 1, 2, 3, 3]));