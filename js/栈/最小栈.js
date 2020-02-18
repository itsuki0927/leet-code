/**
 * initialize your data structure here.
 */
var MinStack = function() {
  this.list = []
  this.min = Number.MAX_VALUE
}

/**
 * @param {number} x
 * @return {void}
 */
MinStack.prototype.push = function(x) {
  this.list.push(x)
  this.min = x < this.min ? x : this.min
}

/**
 * @return {void}
 */
MinStack.prototype.pop = function() {
  const num = this.list.pop()
  if (num === this.min) {
    this.min = Number.MAX_VALUE
    for (let i = this.list.length; i--; ) {
      let x = this.list[i]
      if (x < this.min) {
        this.min = x
      }
    }
  }
}

/**
 * @return {number}
 */
MinStack.prototype.top = function() {
  return this.list[this.list.length - 1]
}

/**
 * @return {number}
 */
MinStack.prototype.getMin = function() {
  return this.min
}

/**
 * ! 评论区答案 使用两个数组
 */
/**
 * initialize your data structure here.
 */
var MinStack = function() {
  this.list = []
  this.minList = []
}

/**
 * @param {number} x
 * @return {void}
 */
MinStack.prototype.push = function(x) {
  this.list.push(x)
  if (!this.minList.length || x <= this.minList[this.minList.length - 1]) {
    this.minList.push(x)
  }
}

/**
 * @return {void}
 */
MinStack.prototype.pop = function() {
  const num1 = this.list[this.list.length - 1]
  const num2 = this.minList[this.minList.length - 1]
  if (num1 === num2) {
    this.minList.pop()
  }
  this.list.pop()
}

/**
 * @return {number}
 */
MinStack.prototype.top = function() {
  return this.list[this.list.length - 1]
}

/**
 * @return {number}
 */
MinStack.prototype.getMin = function() {
  return this.minList[this.minList.length - 1]
}
