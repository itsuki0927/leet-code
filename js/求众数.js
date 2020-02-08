/**
 * @param {number[]} nums
 * @return {number[]}
 */
var majorityElement = function (nums) {
    let count = Math.floor(nums.length / 3);
    let list = [];
    let obj = nums.reduce((acc, val) => {
        acc[val] = (acc[val] || 0) + 1;
        return acc;
    }, {})
    for (let [key, value] of Object.entries(obj)) {
        if (value > count) {
            list.push(key);
        }
    }
    return list;
};
console.log(majorityElement([1, 1, 1, 3, 3, 2, 2, 2]));