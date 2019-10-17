/**
 * @param {number} x
 * @return {boolean}
 */
var isPalindrome = function (x) {
    if (x < 0) {
        return false;
    }
    if (x > 0 && x < 10) {
        return true
    }
    let str = String(x);
    for (let i = 0, len = str.length; i < len / 2; i++) {
        if (str[i] !== str[len - i - 1]) {
            return false;
        }
    }
    return true
};

console.log(isPalindrome(999));