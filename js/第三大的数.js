/**
 * @param {number[]} nums
 * @return {number}
 */
var thirdMax = function (nums) {
    let list = [...new Set(nums)];
    if (list.length < 3) return Math.max(...list);
    let i = 0;
    while (i < 2) {
        let max = Math.max(...list);
        list = list.filter(v => v != max);
        console.log(list)
        i++;
    }
    return Math.max(...list);
};

console.log(thirdMax([2, 2, 3, 1]));