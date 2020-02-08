/**
 * @param {number} num
 * @return {boolean}
 */
var isUgly = function (num) {
    if (num < 1) { return false; }
    let resIndex = 0;
    let nums = [2, 3, 5];
    while (resIndex < 3) {
        if (num % nums[resIndex] == 0) {
            num /= nums[resIndex];
        } else {
            resIndex++;
        }
    }
    return num == 1;
};
var isUgly2 = function (num) {
    if (num < 1) return false;

    while (num % 5 == 0) {
        num /= 5;
    }
    while (num % 3 == 0) {
        num /= 3;
    }
    while (num % 2 == 0) {
        num >>= 1;
    }
    return num == 1;
};

console.log(isUgly(0))