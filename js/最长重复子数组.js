/**
 * @param {number[]} A
 * @param {number[]} B
 * @return {number}
 */
var findLength = function (A, B) {
    let m = A.length,
        n = B.length;
    if (m == 0 || n == 0) return 0;
    // 0的位置初始化为0，省的判断越界问题了
    let dp = Array.from({
        length: m + 1
    }, () => Array(n + 1).fill(0));
    let longest = 0;
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {

            if (A[i] != B[j]) {
                dp[i + 1][j + 1] = 0;
            } else {
                dp[i + 1][j + 1] = 1 + dp[i][j];
                console.log(A[i], B[j])
                longest = Math.max(longest, dp[i + 1][j + 1]);
            }
        }
    }
    return longest;

};

console.log(findLength([1, 2, 3, 2, 1], [3, 2, 1, 4, 7]));