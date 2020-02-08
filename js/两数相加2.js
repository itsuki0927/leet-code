/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function (l1, l2) {
    let stack1 = buildStack(l1);
    let stack2 = buildStack(l2);
    let list = null;

    let carry = 0;
    while (stack1.length || stack2.length || carry) {
        let val = 0;
        if (stack1.length) {
            val += stack1.pop();
        }
        if (stack2.length) {
            val += stack2.pop();
        }
        val += carry;
        carry = Math.floor(val / 10);
        let listNode = new ListNode(val % 10);
        listNode.next = list;
        list = listNode;
    }
    return list;
};

var buildStack = function (list) {
    let stack = [];
    while (list) {
        stack.push(list.val);
        list = list.next;
    }
    return stack;
}