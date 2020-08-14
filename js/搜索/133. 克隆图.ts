/**
 * // Definition for a Node.
 * function Node(val, neighbors) {
 *    this.val = val === undefined ? 0 : val;
 *    this.neighbors = neighbors === undefined ? [] : neighbors;
 * };
 */
class Node1 {
  val?: number
  neighbors?: number[]
  constructor(val?: number, neighbors?: number[]) {
    this.val = val === undefined ? 0 : val
    this.neighbors = neighbors === undefined ? [] : neighbors
  }
}

/**
 * @param {Node} node
 * @return {Node}
 */
var cloneGraph = function (node: Node1) {
  const result: Node1 = null
}
