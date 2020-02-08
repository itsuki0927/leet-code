/**
 * @param {string} num
 * @param {number} k
 * @return {string}
 */
var removeKdigits = function (num, k) {
    if (num.length === k) return "0";
    let stack = [num[0]];
    for (let i = 1, len = num.length; i < len; i++) {
        while (stack[stack.length - 1] > num[i] && k > 0) {
            stack.pop();
            k--;
        }
        if (stack.length || num[i] > 0) {
            stack.push(num[i]);
        }
    }
    while (k--) stack.pop();

    return stack.length ? stack.join('') : '0';
};

console.log(removeKdigits("1432219", 3));