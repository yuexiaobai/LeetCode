/**
 * 116. Populating Next Right Pointers in Each Node
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * 一次完成，稍费了点时间
 */
public class LeetCode116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        Node parent = null, node = root, left = root;
        while (node != null) {
            while (parent != null && parent.next != null) {
                parent.right.next = parent.next.left;
                parent = parent.next;
            }
            while (node != null && node.left != null) {
                node.left.next=node.right;
                node = node.next;
            }
            parent = left;
            node = left.left;
            left = node;
        }
        return root;
    }
}
