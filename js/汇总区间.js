/**
 * @param {number[]} nums
 * @return {string[]}
 */
// var summaryRanges = function (nums) {
//     let list = [];
//     for (let i = 0, j = 0, len = nums.length; i < len; i++) {
//         if (i + 1 < len && nums[i + 1] == nums[i] + 1) continue;
//         if (i == j) list.push(`${nums[i]}`);
//         else list.push(`${nums[j]}->${nums[i]}`);
//         j = i + 1;
//     }
//     return list;
// };
var summaryRanges = function (nums) {
    let p1 = 0;
    let p2 = 0;
    let stack = [];

    for (let i = 1; i < nums.length + 1; i++) {
        if (nums[i] - 1 == nums[i - 1]) p2++;
        else {
            if (p1 == p2) stack.push(`${nums[p1]}`);
            else stack.push(`${nums[p1]}->${nums[p2]}`);
            p1 = i;
            p2 = i;
        }
    }

    return stack;
};
var summaryRanges = function (nums) {
    let list = [],
        p1 = 0,
        p2 = 0;
    for (let i = 1, len = nums.length + 1; i < len; i++) {
        if (nums[i - 1] == nums[i] - 1) {
            p2++;
        } else {
            if (p1 == p2) {
                list.push(`${nums[p1]}`)
            } else {
                list.push(`${nums[p1]}->${nums[p2]}`);
            }
            p1 = i;
            p2 = i;
        }
    }
    return list;
};

console.log(summaryRanges([0, 2, 3, 4, 6, 8, 9]));