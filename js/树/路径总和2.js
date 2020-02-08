/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} sum
 * @return {number[][]}
 */
var pathSum = function (root, sum) {
    let list = [];

    function getAns(root, item, count) {
        if (root == null) return;
        item.push(root.val);
        count -= root.val;
        if (root.left == null && root.right == null && count == 0) {
            list.push([...item]);
            return;
        }
        getAns(root.left, item, count);
        getAns(root.right, item, count);
        item.pop();
    }
    getAns(root, [], sum);
    console.log(list);
};