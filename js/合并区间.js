/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
var merge = function (intervals) {
    let list = []
    intervals.sort((a, b) => (a[0] - b[0]));
    let index = 0,
        len = intervals.length;
    while (index < len) {
        let left = intervals[index][0];
        let right = intervals[index][1];
        while (index < len - 1 && right >= intervals[index + 1][0]) {
            index++;
            right = Math.max(right, intervals[index][1]);
        }
        list.push([left, right]);
        index++;
    }
    return list;
};

console.log(merge([
    [1, 3],
    [2, 6],
    [8, 10],
    [15, 18]
]))