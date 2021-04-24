package connect2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 层次遍历 + 保存前一个节点来连接当前节点
 *
 * @author: itsuki
 * @create: 2021-04-24 09:28
 **/
public class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            // 保存前一个节点
            Node prev = null;
            for (int i = 0; i < n; i++) {
                Node node = queue.poll();
                // 当前层的第一个节点不需要next
                if (i != 0) {
                    // 连接
                    prev.next = node;
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                // 更新prev
                prev = node;
            }
        }

        return root;
    }
}
