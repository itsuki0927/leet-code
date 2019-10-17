/**
 * @param {number[]} nums
 * @param {number} k
 * @return {boolean}
 */
var containsNearbyDuplicate = function (nums, k) {
    let set = [...new Set([...nums])];
    for (let i = 0; i < set.length; i++) {
        let el = set[i];
        let end = nums.lastIndexOf(el);
        let start = nums.indexOf(el);
        if (end - start <= k && end != start) return true
    }
    return false;
};

console.log(containsNearbyDuplicate([11], 1))