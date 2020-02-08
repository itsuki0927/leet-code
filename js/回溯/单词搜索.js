/**
 * @param {character[][]} board
 * @param {string} word
 * @return {boolean}
 */
var exist = function (board, word) {
    const rowLength = board.length;
    const colLength = board[0].length;

    for (let i = 0; i < rowLength; i++) {
        for (let j = 0; j < colLength; j++) {
            if (search(i, j, 0)) { return true; }
        }
    }
    return false;

    function search(x, y, k) {
        if (k >= word.length) return true;
        if (x < 0 || x >= rowLength || y < 0 || y >= colLength || board[x][y] != word[k]) return false;
        board[x][y] = true;
        let result = search(x - 1, y, k + 1) || search(x + 1, y, k + 1) || search(x, y - 1, k + 1) || search(x, y + 1, k + 1);
        board[x][y] = word[k];
        return result;
    }
};

console.log(exist([
    ['A', 'B', 'C', 'E'],
    ['S', 'F', 'C', 'S'],
    ['A', 'D', 'E', 'E']
], "d"))