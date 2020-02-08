/**
 * @param {number} num
 * @return {boolean}
 */
var isPerfectSquare = function (num) {
    if (num == 1) return true;
    let right = Math.floor(num / 2);
    let left = 2;
    while (left <= right) {
        let mid = Math.floor((left + right) / 2);
        if (mid * mid == num) return true;
        if (mid * mid > num) {
            right = mid - 1;
        } else left = mid + 1;
    }
    return false;
};

console.log(isPerfectSquare(17))