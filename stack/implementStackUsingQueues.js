/**
 * Initialize your data structure here.
 */
var MyStack = function () {
  this.data = []
}

/**
 * Push element x onto stack.
 * @param {number} x
 * @return {void}
 */
// push 操作使用临时队列来翻转顺序
MyStack.prototype.push = function (x) {
  const tempQueue = []
  tempQueue.push(x)
  while (this.data.length) {
    tempQueue.push(this.data.shift())
  }
  while (tempQueue.length) {
    this.data.push(tempQueue.shift())
  }
}

/**
 * Removes the element on top of the stack and returns that element.
 * @return {number}
 */
MyStack.prototype.pop = function () {
  return this.data.shift()
}

/**
 * Get the top element.
 * @return {number}
 */
MyStack.prototype.top = function () {
  return this.data[0]
}

/**
 * Returns whether the stack is empty.
 * @return {boolean}
 */
MyStack.prototype.empty = function () {
  return !this.data.length
}

/**
 * Your MyStack object will be instantiated and called as such:
 * var obj = new MyStack()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.empty()
 */
