package postorderTraversal;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: itsuki
 * @create: 2021-04-22 10:08
 **/
public class Solution2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) return ret;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> collect = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            collect.push(node);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        while (!collect.isEmpty()) {
            ret.add(collect.pop().val);
        }
        return ret;
    }
}
