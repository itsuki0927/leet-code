package common;

import java.util.List;

/**
 * @module: mall-
 * @description:
 * @author: itsuki
 * @create: 2021-04-22 13:18
 **/
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
