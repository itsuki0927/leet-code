/**
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */
var combine = function (n, k) {
    let list = [];
    getAns(n, k, 1, [], list);
    return list;
};

var getAns = function (n, k, start, temp, ans) {
    if (temp.length === k) {
        ans.push([...temp]);
        return;
    }
    for (let i = start; i <= n; i++) {
        temp.push(i);
        getAns(n, k, i + 1, temp, ans);
        temp.pop();
    }
}

combine(4, 2);