// 解题思路: 主要是 push 方法, 其他方法就是普通的思路, push 方法的思路就是使用两个 Stack 反转数据, 来达到队列的效果
var MyQueue = function () {
  this.data = []
}

MyQueue.prototype.push = function (x) {
  const tempStack = []
  while (this.data.length) {
    tempStack.unshift(this.data.pop())
  }
  tempStack.unshift(x)
  while (tempStack.length) {
    this.data.unshift(tempStack.pop())
  }
}

MyQueue.prototype.pop = function () {
  return this.data.pop()
}

MyQueue.prototype.peek = function () {
  return this.data[this.data.length - 1]
}

MyQueue.prototype.empty = function () {
  return !this.data.length
}
