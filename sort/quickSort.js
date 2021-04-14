const swap = (arr, i, j) => {
  const num = arr[i]
  arr[i] = arr[j]
  arr[j] = num
}

const partition = (arr, l, r) => {
  // <区边界
  let less = l - 1,
    // >区边界
    more = r
  while (l < more) {
    if (arr[l] > arr[r]) {
      swap(arr, l, --more)
    } else if (arr[l] < arr[r]) {
      swap(arr, l++, ++less)
    } else {
      l++
    }
  }
  // 交换>区第一个数与查找值做交换
  swap(arr, more, r)
  return [less + 1, more]
}

// 随机快排
const quickSort = (arr, l, r) => {
  if (l < r) {
    swap(arr, l + Math.floor(Math.random() * (r - l + 1)), r)
    // 左边界、右边界
    const [less, more] = partition(arr, l, r)
    // 排序 <区
    quickSort(arr, l, less - 1)
    // 排序 >区
    quickSort(arr, more + 1, r)
  }
}

const arr = [1, 20, 3, 5, 10, 8, 2, 7, 6]
quickSort(arr, 0, arr.length - 1)
console.log('arr:', arr)
