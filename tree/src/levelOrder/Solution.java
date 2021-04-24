package levelOrder;

import common.TreeNode;

import java.util.*;

/**
 * 解题思路: BFS
 *
 * @author: itsuki
 * @create: 2021-04-22 10:52
 **/
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return ret;
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }

        return ret;
    }
}
