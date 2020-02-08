/**
 * @param {number[]} guess
 * @param {number[]} answer
 * @return {number}
 */
var game = function (guess, answer) {
    let count = 0;
    for (let i = 0; i < 3; i++) {
        if (guess[i] == answer[i]) {
            count++;
        }
    }
    return count;
};

console.log(game([2, 2, 3], [3, 2, 1]));