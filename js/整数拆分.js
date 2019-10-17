/**
 * @param {number} n
 * @return {number}
 * @description 记忆法搜索
 */
var integerBreak = function (n) {
    let memory = Array(n + 1).fill(0);

    function dfs(num) {
        if (num == 2) return 1;
        if (memory[num]) return memory[num];

        let res = -1;
        for (let i = 1; i <= num - 1; i++) {
            res = Math.max(res, Math.max(i * dfs(num - i), i * (num - i)))
        }
        memory[num] = res;
        return res;
    }
    return dfs(n);
};
// 动态规划
var integerBreak = function (n) {
    let memory = Array(n + 1).fill(0);
    memory[2] = 1;
    for (let i = 3; i <= n; i++) {
        for (let j = 1; j <= i - 1; j++) {
            memory[i] = Math.max(memory[i], Math.max(j * memory[i - j], j * (i - j)));
        }
    }
    return memory[n];
};
// 贪心
var integerBreak = function (n) {
    if (n == 2)
        return 1;
    if (n == 3)
        return 2;
    let a = 1;
    while (n > 4) {
        n = n - 3;
        a = a * 3;
    }
    return a * n;
};

console.log(integerBreak(10));