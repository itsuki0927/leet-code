/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {string[]}
 */

var obj = {
    val: 1,
    right: {
        val: 3,
        right: null,
        left: null
    },
    left: {
        val: 2,
        right: {
            val: 5,
            right: null,
            left: null
        },
        left: null
    }
}

var binaryTreePaths = function (root) {
    let strList = [];
    if (!root) return strList;
    deep(root, strList, root.val + '');


    function deep(curr, list, str) {
        console.log(curr.val);
        if (curr && !curr.left && !curr.right) {
            list.push(str)
            return;
        }
        if (curr.left) deep(curr.left, list, `${str}->${curr.left.val}`);
        if (curr.right) deep(curr.right, list, `${str}->${curr.right.val}`);
    }
    return strList;
};

console.log(binaryTreePaths(obj));