package connect2;

/**
 * 解题思路: 把每一层当作链表来处理
 *
 * @author: itsuki
 * @create: 2021-04-24 09:44
 **/
public class Solution2 {
    public Node connect(Node root) {
        if (root == null) return null;
        // current可以把它看作每一层的链表
        Node current = root;
        Node fake = new Node(0);
        while (current != null) {
            fake.next = null;
            // 当前节点的前一个节点
            Node prev = fake;
            while (current != null) {
                // 如果有左孩子
                if (current.left != null) {
                    // 串起来
                    prev.next = current.left;
                    // 更新prev
                    prev = prev.next;
                }
                if (current.right != null) {
                    prev.next = current.right;
                    prev = prev.next;
                }
                // 处理当前层的下一个节点
                current = current.next;
            }
            // 移动到下一层
            current = fake.next;
        }
        return root;
    }
}
