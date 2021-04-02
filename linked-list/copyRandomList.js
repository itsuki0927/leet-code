/**
 * 解题思路:
 *
 * 1. 首先对每一个节点复制,将复制的节点放到当前的节点后面,比如说: 1->2->3->4, 复制之后就是: 1->1'->2->2'->3->3'->4->4'
 * 2. 处理random节点, 这里通过复制之后有一个映射关系random的复制节点就是random.next节点,即: copyNode.random = node.random.next(判断null)
 * 3. 最后将复制的节点拆出来
 *
 * @param {Node} head
 * @return {Node}
 */
var copyRandomList = function (head) {
  if (head == null) return head

  let current = head,
    next = null,
    copyCurrent = null

  // 复制每一个节点,并将复制后的节点插到当前节点后面
  while (current != null) {
    next = current.next
    const copyNode = new Node(current.val)
    current.next = copyNode
    copyNode.next = next
    current = next
  }

  // 复制节点的random
  current = head
  while (current != null) {
    next = current.next.next
    copyCurrent = current.next
    copyCurrent.random = current.random != null ? current.random.next : null
    current = next
  }

  // 将复制后的节点拆离出来
  let newHead = head.next
  current = head
  while (current != null) {
    next = current.next.next
    copyCurrent = current.next
    current.next = next
    copyCurrent.next = next == null ? null : next.next
    current = next
  }

  return newHead
}

// dfs
var copyRandomList = function (head) {
  const map = new Map()
  function dfs(head) {
    if (head == null) return null
    if (map.has(head)) {
      return map.get(head)
    }
    const copyNode = new Node(head.val)
    map.set(head, copyNode)
    copyNode.next = dfs(head.next)
    copyNode.random = dfs(head.random)
    return copyNode
  }
  return dfs(head)
}
