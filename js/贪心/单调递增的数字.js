/**
 * @param {number} N
 * @return {number}
 */
var monotoneIncreasingDigits = function (N) {
    let list = String(N).split('');
    let flag = list.length;
    for (let i = list.length - 1; i >= 1; i--) {
        if (list[i - 1] > list[i]) {
            flag = i;
            list[i - 1]--;
        }
    }
    for (let i = flag; i < list.length; i++) {
        list[i] = 9;
    }
    return Number(list.join(''));
};

console.log(monotoneIncreasingDigits(332));