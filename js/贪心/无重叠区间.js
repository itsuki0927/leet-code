/**
 * @param {number[][]} intervals
 * @return {number}
 * @description  贪心算法，按照起点排序：选择结尾最短的，后面才可能连接更多的区间（如果两个区间有重叠，应该保留结尾小的） 
 * 把问题转化为最多能保留多少个区间，使他们互不重复，则按照终点排序，每个区间的结尾很重要，结尾越小，则后面越有可能容纳更多的区间。
 */
var eraseOverlapIntervals = function (intervals) {
    if (intervals.length == 0) return 0;
    intervals.sort((v1, v2) => (v1[1] - v2[1]));

    let ans = 1,
        end = intervals[0][1];
    for (let i = 0, len = intervals.length; i < len; i++) {
        let start = intervals[i][0];
        if (start >= end) {
            ans++;
            end = intervals[i][1];
        }
    }
    return intervals.length - ans;
};


console.log(eraseOverlapIntervals([
    [1, 2],
    [2, 3],
    [3, 4],
    [1, 3]
]));