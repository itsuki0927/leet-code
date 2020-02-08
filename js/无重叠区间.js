/**
 * @param {number[][]} intervals
 * @return {number}
 */
var eraseOverlapIntervals = function (intervals) {
    intervals.sort((a, b) => (a[0] - b[0] || a[1] - b[1]));
    console.log(intervals);
};

console.log(eraseOverlapIntervals([
    [1, 2],
    [2, 3],
    [3, 5],
    [3, 4],
    [1, 3],
]))