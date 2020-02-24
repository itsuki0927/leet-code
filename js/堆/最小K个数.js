/**
 * @param {number[]} arr
 * @param {number} k
 * @return {number[]}
 */
var smallestK = function(arr, k) {
  const heap = [-10000]
  for (let i = 0, len = arr.length; i < len; i++) insert(heap, arr[i])

  console.log(heap)
}

var insert = function(arr, k) {
  let i = arr.length
  for (; arr[i / 2] < k; i = Math.floor(i / 2)) {
    console.log(i / 2)

    arr[i] = arr[i / 2]
  }
  arr[i] = k
}

smallestK([1, 3, 5, 7, 2, 4, 6, 8])
