/**
 * @param {number} n
 * @return {number}
 */
var countNumbersWithUniqueDigits = function (n) {
    if (0 == n) return 1;
    if (1 == n) return 10;
    let sum = 10;
    let dp = 9;
    for (let i = 2; i <= n; ++i) {
        dp = dp * (10 - i + 1);
        sum += dp;
    }
    return sum;
};
var countNumbersWithUniqueDigits2 = function (n) {
    if (n == 0) return 1;
    if (n == 1) return 10;
    let dp = [];
    dp[1] = 10;
    dp[2] = 91;
    for (let i = 3; i < n + 1; i++) {
        dp[i] = (dp[i - 1] - dp[i - 2]) * (10 - i + 1) + dp[i - 1];
    }
    return dp[n];
};

var countNumbersWithUniqueDigits3 = function (n) {
    if (n == 0) return 1;
    if (n == 1) return 10;
    let sum = 10;
    let dp = 9;
    for (let i = 2; i <= n; i++) {
        dp = dp * (10 - i + 1);
        sum += dp;
    }
    return sum;
}

console.log(countNumbersWithUniqueDigits(2));