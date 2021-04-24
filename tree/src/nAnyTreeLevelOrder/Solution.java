package nAnyTreeLevelOrder;

import common.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 解题思路: 层级遍历
 *
 * @author: itsuki
 * @create: 2021-04-22 13:17
 **/
public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                list.add(node.val);
                if (node.children != null) {
                    List<Node> children = node.children;
                    for (int j = 0; j < children.size(); j++) {
                        queue.offer(children.get(j));
                    }
                }
            }
            ret.add(list);
        }
        return ret;
    }
}
