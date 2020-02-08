/**
 * @param {number[]} nums
 * @return {number}
 */
var findDuplicate = function (nums) {
    let set = new Set();
    for (let i = 0, len = nums.length; i < len; i++) {
        let key = nums[i];
        if (set.has(key)) return key;
        set.add(key);
    }
};

console.log(findDuplicate([3, 1, 3, 4, 2]));