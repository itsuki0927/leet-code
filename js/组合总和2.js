/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum2 = function (candidates, target) {
    let list = [];
    let len = candidates.length;
    candidates.sort();
    foo(target, 0, []);

    function foo(sum, begin, sumList) {
        if (sum < 0) return;
        if (!sum) {
            list.push([...sumList]);
            return;
        }
        for (let i = begin; i < len; i++) {
            let el = candidates[i];
            //相同数字只允许循环的第一个递归，避免重复
            if (i > begin && candidates[i - 1] == el) {
                continue;
            }
            sumList.push(el);
            foo(sum - el, i + 1, sumList);
            sumList.pop();
        }
    }
    return list;
};

console.log(combinationSum2([10, 1, 2, 7, 6, 1, 5], 8));