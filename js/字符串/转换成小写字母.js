/**
 * @param {string} str
 * @return {string}
 */
var toLowerCase = function (str) {
    // return str.toLowerCase();
    let list = [];
    for (let i = 0, len = str.length; i < len; i++) {
        if (str[i] >= 'A' && str[i] <= 'Z') {
            list.push(str[i].toLowerCase());
        } else {
            list.push(str[i])
        }
    }
    return list.join('');
};

console.log(toLowerCase('LOVELY'))