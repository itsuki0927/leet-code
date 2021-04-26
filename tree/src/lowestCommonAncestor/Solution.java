package lowestCommonAncestor;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 解题思路: 先用HashMap保存所有节点的父节点, 然后将一个节点的所有父节点放入Set中, 最后在将另一个节点往上查找
 * 父节点, 如果在Set中表示是第一个公共父节点
 *
 * @author: itsuki
 * @create: 2021-04-26 16:14
 **/
public class Solution {
    private void process(TreeNode head, HashMap<TreeNode, TreeNode> fatherMap) {
        if (head == null) return;

        fatherMap.put(head.left, head);
        fatherMap.put(head.right, head);
        process(head.left, fatherMap);
        process(head.right, fatherMap);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode, TreeNode> fatherMap = new HashMap<>();
        fatherMap.put(root, root);
        // 将节点的父节点存入HashMap
        process(root, fatherMap);
        HashSet<TreeNode> set1 = new HashSet<>();
        TreeNode current = p;
        // 如果p不等于父节点
        while (current != fatherMap.get(current)) {
            // 添加到set中
            set1.add(current);
            // 往上找
            current = fatherMap.get(current);
        }
        current = q;
        // 如果q不等于父节点
        while (current != fatherMap.get(current)) {
            // 如果存在set1中, 找到了公共父节点
            if (set1.contains(current)) return current;
            current = fatherMap.get(current);
        }
        return null;
    }
}
