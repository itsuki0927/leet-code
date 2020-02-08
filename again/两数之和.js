/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function (nums, target) {
    let map = new Map();
    for (let i = 0; i < nums.length; i++) {
        let el = nums[i];
        if (map.has(target - el)) {
            return [i, map.get(target - el)];
        }
        map.set(el, i);
    }
    return [];
};

console.log(twoSum([2, 7, 11, 15], 9));