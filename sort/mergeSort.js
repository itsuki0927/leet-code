function sort(list, left, right) {
  if (left === right) return
  const mid = left + Math.floor((right - left) / 2)
  sort(list, left, mid)
  sort(list, mid + 1, right)
  merge(list, left, mid + 1, right)
}

function merge(list, left, right, bound) {
  const mid = right - 1,
    temp = []
  let i = left,
    j = right,
    k = 0

  while (i <= mid && j <= bound) {
    if (list[i] < list[j]) {
      temp[k++] = list[i++]
    } else {
      temp[k++] = list[j++]
    }
  }

  while (i <= mid) temp[k++] = list[i++]
  while (j <= bound) temp[k++] = list[j++]

  for (let i = 0; i < temp.length; i++) {
    list[left + i] = temp[i]
  }

  return temp
}

const test = list => {
  sort(list, 0, list.length - 1)
  return list
}

console.log(test([1, 4, 7, 8, 3, 6, 9]))
