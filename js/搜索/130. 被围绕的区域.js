/**
 * @param {character[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
//  思路就是:
// 将边界的'O'用其他字符比如说'#'替换,
// 将所有的'O'(也就是非边界的'O')替换成'X', 再将'#'替换成'O'
// dfs
var solve = function (board) {
  if (board == null || board.length == 0) return
  let m = board.length
  let n = board[0].length

  const dfs = (list, i, j) => {
    if (
      i < 0 ||
      j < 0 ||
      i >= list.length ||
      j >= list[0].length ||
      list[i][j] == 'X' ||
      list[i][j] == '#'
    ) {
      return
    }
    // list[i][j] == '#' 说明已经搜索过了.
    list[i][j] = '#'
    dfs(list, i - 1, j) // 上
    dfs(list, i + 1, j) // 下
    dfs(list, i, j - 1) // 左
    dfs(list, i, j + 1) // 右
  }

  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      // 从边缘o开始搜索
      const isEdge = i == 0 || j == 0 || i == m - 1 || j == n - 1
      if (isEdge && board[i][j] == 'O') {
        dfs(board, i, j)
      }
    }
  }
  console.log('board:', board)
  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      if (board[i][j] == 'O') {
        board[i][j] = 'X'
      }
      if (board[i][j] == '#') {
        board[i][j] = 'O'
      }
    }
  }
}

const list2 = [
  ['O', 'O', 'O'],
  ['O', 'O', 'O'],
  ['O', 'O', 'O'],
]
const list = [
  ['X', 'X', 'X', 'X'],
  ['X', 'O', 'O', 'X'],
  ['X', 'X', 'O', 'X'],
  ['X', 'O', 'X', 'X'],
]

solve(list)

// 栈
var solveStack = function (board) {
  if (board == null || board.length == 0) return
  let m = board.length
  let n = board[0].length

  const dfs = (list, i, j) => {
    const stack = []
    stack.push({ i, j })
    list[i][j] = '#'
    while (list.length) {
      const { i, j } = list[list.length - 1]

      // 上
      if (i - 1 >= 0 && list[i - 1][j] === 'O') {
        list[i - 1][j] = '#'
        stack.push({ i: i - 1, j })
        continue
      }
      // 下
      if (i + 1 <= m - 1 && list[i + 1][j] === 'O') {
        list[i + 1][j] = '#'
        stack.push({ i: i + 1, j })
        continue
      }
      // 右
      if (j + 1 <= n - 1 && list[i][j + 1] === 'O') {
        list[i][j + 1] = '#'
        stack.push({ j: j + 1, i })
        continue
      }
      // 左
      if (j - 1 >= 0 && list[i][j - 1] === 'O') {
        list[i][j - 1] = '#'
        stack.push({ j: j - 1, i })
        continue
      }
      stack.pop()
    }
  }

  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      // 从边缘o开始搜索
      const isEdge = i == 0 || j == 0 || i == m - 1 || j == n - 1
      if (isEdge && board[i][j] == 'O') {
        dfs(board, i, j)
      }
    }
  }
  console.log('board:', board)
  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      if (board[i][j] == 'O') {
        board[i][j] = 'X'
      }
      if (board[i][j] == '#') {
        board[i][j] = 'O'
      }
    }
  }
}
// 队列
var solveQueue = function (board) {
  if (board == null || board.length == 0) return
  let m = board.length
  let n = board[0].length

  const bfs = (list = [], i, j) => {
    const queue = []
    queue.push({ i, j })
    list[i][j] = '#'
    while (queue.length) {
      const { i, j } = queue.shift()

      // 上
      if (i - 1 >= 0 && list[i - 1][j] === 'O') {
        list[i - 1][j] = '#'
        queue.push({ i: i - 1, j })
      }
      // 下
      if (i + 1 <= m - 1 && list[i + 1][j] === 'O') {
        list[i + 1][j] = '#'
        queue.push({ i: i + 1, j })
      }
      // 右
      if (j + 1 <= n - 1 && list[i][j + 1] === 'O') {
        list[i][j + 1] = '#'
        queue.push({ j: j + 1, i })
      }
      // 左
      if (j - 1 >= 0 && list[i][j - 1] === 'O') {
        list[i][j - 1] = '#'
        queue.push({ j: j - 1, i })
      }
    }
  }

  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      // 从边缘o开始搜索
      const isEdge = i == 0 || j == 0 || i == m - 1 || j == n - 1
      if (isEdge && board[i][j] == 'O') {
        bfs(board, i, j)
      }
    }
  }
  console.log('board:', board)
  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      if (board[i][j] == 'O') {
        board[i][j] = 'X'
      }
      if (board[i][j] == '#') {
        board[i][j] = 'O'
      }
    }
  }
}
