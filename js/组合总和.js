/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum = function (candidates, target) {
    let list = [];

    candidates.sort();

    getList(target, 0, []);

    function getList(sum, start, sumList) {
        if (sum < 0) return;
        if (sum === 0) {
            list.push([...sumList]);
            return;
        }

        for (let i = start, len = candidates.length; i < len; i++) {
            const ele = candidates[i];
            sumList.push(ele);
            getList(sum - ele, i, sumList);
            sumList.pop();
        }
    }

    return list;
};


console.log(combinationSum([2, 3, 5], 8));