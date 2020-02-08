/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var subarraySum = function (nums, k) {
    let curr = 0,
        result = 0,
        map = new Map;
    map.set(0, 1);
    for (let i = 0, len = nums.length; i < len; i++) {
        curr += nums[i];

        if (map.has(curr - k)) {
            result += map.get(curr - k);
        }

        if (map.has(curr)) {
            map.set(curr, map.get(curr) + 1)
        } else {
            map.set(curr, 1)
        }
    }
    return result;
};

console.log(subarraySum([1, 2, 3, 4, 5], 10));