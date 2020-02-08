/**
 * @param {number[][]} triangle
 * @return {number}
 */
var minimumTotal = function (triangle) {
    if (triangle == null || triangle.length == 0) return 0;

    // 只需要记录每一层的最小值即可
    let dp = new Array(triangle.length + 1).fill(0);

    for (let i = triangle.length - 1; i >= 0; i--) {
        let curTr = triangle[i];
        for (let j = 0, len = curTr.length; j < len; j++) {
            dp[j] = Math.min(dp[j], dp[j + 1]) + curTr[j];
        }
    }
    return dp[0];
};
console.log(
    minimumTotal([
        [2],
        [3, 4],
        [6, 5, 7],
        [4, 1, 8, 3]
    ]));