/**
 * @param {number} n
 * @return {number}
 */
var nextGreaterElement = function (n) {
    let str = n.toString(),
        left = '',
        right = '',
        point = '';
    for (let i = str.length - 1; i >= 1; i--) {
        if (str[i] > str[i - 1]) {
            right = str.slice(i);
            left = str.slice(0, i - 1);
            point = str[i - 1];
            break;
        }
    }
    if (right.length == 0) return -1;
    right = right.split('').sort();
    for (let i = 0; i < right.length; i++) {
        if (right[i] > point) {
            [right[i], point] = [point, right[i]];
            break;
        }
    }
    let number = Number(left + point + right.join(''));
    if (number.toString(2).length > 31) return -1; // 一个符号位
    return number;
};


console.log(nextGreaterElement(230241));