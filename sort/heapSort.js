const swap = (arr, i, j) => {
  const num = arr[i]
  arr[i] = arr[j]
  arr[j] = num
}

const heapInsert = (arr, index) => {
  while (arr[index] > arr[(index - 1) >> 1]) {
    swap(arr, index, (index - 1) >> 1)
    index = (index - 1) >> 1
  }
}

const heapify = (arr, index, size) => {
  let left = index * 2 + 1
  while (left < size) {
    // 两个孩子, 大的下标给largest
    let largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left

    // 父亲和较大的孩子之间, 大的下标给largest
    largest = arr[largest] > arr[index] ? largest : index
    if (largest === index) break

    swap(arr, index, largest)
    index = largest
    left = index * 2 + 1
  }
}

const headSort = arr => {
  let heapSize = arr.length
  if (arr == null || heapSize < 2) return
  for (let i = 0; i < heapSize; i++) heapInsert(arr, i)
  swap(arr, 0, --heapSize)
  while (heapSize) {
    heapify(arr, 0, heapSize)
    swap(arr, 0, --heapSize)
  }
  return arr
}
const list = [1, 5, 3, 5, 2, 3, 4]
console.log(headSort(list))
