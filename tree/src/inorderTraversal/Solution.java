package inorderTraversal;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 解题思路: 递归
 *
 * @author: itsuki
 * @create: 2021-04-22 09:23
 **/
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        answer(root, ret);
        return ret;
    }

    public void answer(TreeNode node, List<Integer> list) {
        if (node == null) return;

        answer(node.left, list);
        list.add(node.val);
        answer(node.right, list);
    }
}
