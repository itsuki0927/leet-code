/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 * @description 暴力超时 动态规划
 */
var uniquePaths = function (m, n) {
    let count = 0;

    function dfs(x, y) {
        // console.log(x, y)
        if (x >= m || y >= n || x < 0 || y < 0) return;
        if (x == m - 1 && y == n - 1) {
            count++;
            return;
        }
        dfs(x + 1, y);
        dfs(x, y + 1);
    }
    dfs(0, 0);
    return count;
};

console.log(uniquePaths(7, 3));