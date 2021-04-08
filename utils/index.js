function Node(val, next) {
  this.val = val
  this.next = next
}

function RandomNode(val, next, random) {
  this.val = val
  this.next = next
  this.random = random
}

/**
 * 根据数组生成链表
 *
 * @param {number[]} list
 */
const generateListNode = list => {
  if (list.length === 0) return null
  const fake = new Node(-1)
  let current = fake
  list.forEach(val => {
    current.next = new Node(val)
    current = current.next
  })
  return fake.next
}

const generateRandomListNode = list => {
  if (list.length === 0) return null
  const fake = new Node(-1)
  let current = fake
  list.forEach(val => {
    current.next = new Node(val)
    current = current.next
  })
  return fake.next
}
