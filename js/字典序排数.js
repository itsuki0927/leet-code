/**
 * @param {number} n
 * @return {number[]}
 */
var lexicalOrder = function (n) {
    let result = [];
    for (let i = 1; i <= 9; i++) {
        if (i <= n) {
            result.push(i);
            addResult(i);
        } else break;
    }

    function addResult(startNum) {
        startNum *= 10;
        for (let i = 0; i < 10; i++, startNum++) {
            if (startNum <= n) {
                result.push(startNum);
                addResult(startNum);
            } else return;
        }
    }

    return result;
};

var lexicalOrder3 = function (n) {
    return Array.from({
        length: n
    }).map((val, i) => ((i + 1) + '')).sort()
};

console.log(lexicalOrder(100));