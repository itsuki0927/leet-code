package connect;

import common.ConnectNode;

/**
 * @author: itsuki
 * @create: 2021-04-23 10:06
 **/
public class Solution2 {
    public ConnectNode connect(ConnectNode root) {
        if (root == null) return null;
        ConnectNode leftMost = root;
        while (leftMost.left != null) {
            ConnectNode temp = leftMost;
            while (temp != null) {
                // 第一种情况: 连接同一个父节点的两个节点
                temp.left.next = temp.right;

                // 第二种情况: 连接不同父节点的两个节点
                if (temp.next != null) {
                    temp.right.next = temp.next.left;
                }

                // 移到下一个节点
                temp = temp.next;
            }

            // 下一层的最左节点
            leftMost = leftMost.left;
        }
        return root;
    }
}
