/**
 * @param {string} num1
 * @param {string} num2
 * @return {string}
 */
var multiply = function (num1, num2) {
    if (!num1 || !num2) return '0';
    let i = 0,
        len1 = num1.length - 1,
        len2 = num2.length - 1;
    let str = Array.from({
        length: len1 + len2 + 2
    }, () => 0);
    for (let i = len1; i >= 0; i--) {
        for (let j = len2; j >= 0; j--) {
            let digital1 = num1[i] - '0';
            let digital2 = num2[j] - '0';
            let product = digital1 * digital2 + str[i + j + 1];

            str[i + j] += Math.floor(product / 10);
            str[i + j + 1] = product % 10;
        }
    }
    while (i < str.length - 1 && !str[i])
        i++;
    return str.join('').slice(i);
};

console.log(multiply("123", "456"));