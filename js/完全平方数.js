/**
 * @param {number} n
 * @return {number}
 * @description 动态规划
 */
var numSquares = function (n) {
    let count = Number.MAX_VALUE;

    function dfs(sum, start, result) {
        if (sum == 0) {
            count = Math.min(result, count);
            return;
        }
        for (let i = start; i >= 1; i--) {
            if (result > count) return;
            if (i > ((sum / i) | 0)) continue;
            result++;
            dfs(sum - (i * i), i, result);
            result--;
        }
    }
    dfs(n, ~~Math.sqrt(n), 0);
    return count;
};
var numSquares = function (n) {
    const dp = Array(n + 1).fill(0); // 数组长度为n+1，值均为0
    for (let i = 1; i <= n; i++) {
        dp[i] = i; // 最坏的情况就是每次+1
        for (let j = 1; i - j * j >= 0; j++) {
            dp[i] = Math.min(dp[i], dp[i - j * j] + 1); // 动态转移方程
        }
    }
    return dp[n];
};

console.log(numSquares(19));