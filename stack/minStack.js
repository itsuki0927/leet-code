// 解题思路: 使用一个最小值栈保存每一个状态的最小值
var MinStack = function () {
  this.data = []
  this.minStack = []
}

MinStack.prototype.push = function (val) {
  const minNum = this.minStack[this.minStack.length - 1]
  const minNumber = val < minNum || !this.data.length ? val : minNum
  this.data.push(val)
  this.minStack.push(minNumber)
}

// 将最小值栈、数据栈同步弹出
MinStack.prototype.pop = function () {
  this.minStack.pop()
  return this.data.pop()
}

MinStack.prototype.top = function () {
  return this.data[this.data.length - 1]
}

MinStack.prototype.getMin = function () {
  return this.minStack[this.minStack.length - 1]
}
