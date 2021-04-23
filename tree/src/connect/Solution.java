package connect;

import common.ConnectNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author: itsuki
 * @create: 2021-04-22 13:37
 **/
public class Solution {
    public ConnectNode connect(ConnectNode root) {
        Queue<ConnectNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                ConnectNode node = queue.poll();
                if (i < n - 1) {
                    node.next = queue.peek();
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return root;
    }
}
