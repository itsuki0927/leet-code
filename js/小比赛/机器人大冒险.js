/**
 * @param {string} command
 * @param {number[][]} obstacles
 * @param {number} x
 * @param {number} y
 * @return {boolean}
 */
var robot = function (command, obstacles, x, y) {

    let count = 0;

    function dfs(moveX, moveY) {
        if (moveX > x || moveY > y) return false
        if (moveX == x && moveY == y) return true;

        if (obstacles.some(v => (v[0] == moveX && v[1] == moveY))) return false;

        if (command[count++ % command.length] == 'U') {
            return dfs(moveX, moveY + 1)
        } else return dfs(moveX + 1, moveY);
    }
    return dfs(0, 0);
};

console.log(robot('URR', [], 3, 2));