/**
 * @param {number[]} coins
 * @param {number} amount
 * @return {number}
 */
var coinChange = function (coins, amount) {
    var minCount = Number.MAX_VALUE;
    coins.sort((a, b) => (a - b));

    function dp(amount, count, index) {
        let num = Math.floor(amount / coins[index]);
        if (index < 0 || count + num >= minCount) return;
        if (amount % coins[index] == 0) {
            minCount = Math.min(minCount, count + num);
            return;
        }
        for (let i = num; i >= 0; i--) {
            dp(amount - i * coins[index], count + i, index - 1);
        }
    }
    dp(amount, 0, coins.length - 1);
    return minCount === Number.MAX_VALUE ? -1 : minCount;
};

console.log(coinChange([1, 2, 5], 19));