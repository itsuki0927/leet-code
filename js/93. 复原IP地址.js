/**
 * @param {string} s
 * @return {string[]}
 */
// 暴力破解法
var restoreIpAddresses = function (s) {
  const result = []
  let str = ''
  for (let a = 1; a < 4; a++) {
    for (let b = 1; b < 4; b++) {
      for (let c = 1; c < 4; c++) {
        for (let d = 1; d < 4; d++) {
          if (a + b + c + d === s.length) {
            const str1 = +s.substring(0, a)
            const str2 = +s.substring(a, a + b)
            const str3 = +s.substring(a + b, a + b + c)
            const str4 = +s.substring(a + b + c)
            if (str1 <= 255 && str2 <= 255 && str3 <= 255 && str4 <= 255) {
              str = `${str1}.${str2}.${str3}.${str4}`
              if (str.length === s.length + 3) {
                result.push(str)
              }
              str = ''
            }
          }
        }
      }
    }
  }
  console.log('result:', result)
  return result
}

/**
 * 回溯写法
 * @param {string} s
 * @returns {string[]} result
 */
const restoreIpAddresses = s => {
  const result = []

  const dfs = (res = [], start) => {
    // 如果res组成了一个ip地址 && 把s字符串用完了
    if (res.length === 4 && start === s.length) {
      result.push(res.join('.'))
      return
    }
    // 如果res组成了一个ip地址 && 没有s字符串用完了
    if (res.length === 4 && start < s.length) {
      return
    }
    // 三种长度的选择
    for (let len = 1; len <= 3; len++) {
      // 指针越界
      if (start + len - 1 >= s.length) return
      // 不能是0x、0xx
      if (s[start] == '0' && len !== 1) return
      // 切割出当前选中的片段
      const str = s.substring(start, start + len)
      // 不能超过255
      if (len === 3 && +str > 255) return
      // 作出选择
      res.push(str)
      // 基于这种选择
      dfs(res, start + len)
      // 撤销最后的选择,回到之前的状态
      res.pop()
    }
  }

  dfs([], 0)
  return result
}
