package preorderTraversal;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 解题思路: 递归
 *
 * @author: itsuki
 * @create: 2021-04-22 09:33
 **/
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        answer(root, ret);
        return ret;
    }

    public void answer(TreeNode node, List list) {
        if (node == null) return;

        list.add(node.val);
        answer(node.left, list);
        answer(node.right, list);
    }
}
