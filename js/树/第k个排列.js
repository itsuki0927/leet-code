/**
 * 逆康托展开
 * 
 *  首先用96-1得到95，说明x之前有95个排列.(将此数本身减去1)
    用95去除4! 得到3余23，说明有3个数比第1位小，所以第一位是4.
    用23去除3! 得到3余5，说明有3个数比第2位小，所以是4，但是4已出现过，因此是5.
    用5去除2!得到2余1，类似地，这一位是3.
    用1去除1!得到1余0，这一位是2.
    最后一位只能是1.
    所以这个数是45321.
 */

/**
 * @param {number} n
 * @param {number} k
 * @return {string}
 */
var getPermutation = function(n, k) {
  const candidates = [],
    factorials = [1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880],
    list = []
  k -= 1
  for (let i = 1; i <= n; ++i) {
    candidates.push(i)
  }
  for (let i = n - 1; i >= 0; --i) {
    // 计算候选数字的index
    let index = Math.floor(k / factorials[i])
    list.push(candidates[index])
    candidates.splice(index, 1)
    k -= index * factorials[i]
  }

  return list.join('')
}

console.log(getPermutation(5, 96))
