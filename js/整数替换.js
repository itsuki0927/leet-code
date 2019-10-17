/**
 * @param {number} n
 * @return {number}
 */
var integerReplacement = function (n) {
    let minCount = Number.MAX_VALUE;

    function getCount(num, count) {
        if (num === 1 || num === 3) {
            if (num === 3) count += 2;
            minCount = minCount > count ? count : minCount;
            return;
        }
        if (num % 2) {
            getCount(num + 1, count + 1);
            getCount(num - 1, count + 1);
        } else {
            getCount(num / 2, count + 1);
        }
    }
    getCount(n, 0);
    return minCount;
};

var integerReplacement2 = function (n) {

    return function getCount(num) {
        if (num === 3) return 2;
        if (num === 1) return 0;
        if (num % 2) {
            return 1 + Math.min(getCount(num + 1), getCount(num - 1))
        } else return 1 + getCount(num / 2);
    }(n)
};
console.log(integerReplacement(7));