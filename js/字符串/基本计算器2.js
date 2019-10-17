/**
 * @param {string} s
 * @return {number}
 */
var calculate = function (s) {
    let stack = [],
        result = 0,
        d = 0,
        sign = '+';

    for (let i = 0, len = s.length; i < len; ++i) {
        if (s[i] >= '0' && s[i] <= '9') {
            // 如果是连续字符  比如说 '42'
            d = d * 10 + Number(s[i]);
        }

        if ((s[i] < '0' && s[i] != ' ') || i == len - 1) {
            if (sign == '+') {
                stack.push(d);
            } else if (sign == '-') {
                stack.push(-d);
            } else if (sign == '*' || sign == '/') {
                let tmp = sign == '*' ? stack.pop() * d : ((stack.pop() / d) | 0);
                stack.push(tmp);
            }
            sign = s[i];
            d = 0;
        }
    }
    for (; stack.length;) {
        result += stack.pop();
    }
    return result;

};

console.log(calculate('42'))