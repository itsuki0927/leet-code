/**
 * @param {number} k
 * @param {number} n
 * @return {number[][]}
 */
var combinationSum3 = function (k, n) {
    let list = [];

    function dp(item, sum, start) {
        if (item.length == k && !sum) {
            list.push([...item]);
            return;
        }
        for (let i = start; i <= 9; i++) {
            item.push(i);
            dp(item, sum - i, i + 1);
            item.pop();
        }
    }

    dp([], n, 1);
    return list;
};

console.log(combinationSum3(3, 9));