/**
 * 117. Populating Next Right Pointers in Each Node II
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 * 没有做出来，参考博客https://www.cnblogs.com/grandyang/p/4290148.html第三种解法
 * 用两个指针模拟队列实现，比较巧妙
 * TODO 如此巧妙，只能常来看看了
 */
public class LeetCode117 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        Node head = new Node();
        Node cur = head;
        Node node = root;
        while (node != null) {
            if (node.left != null) {
                cur.next = node.left;
                cur = cur.next;
            }
            if (node.right != null) {
                cur.next = node.right;
                cur = cur.next;
            }
            node = node.next;
            if (node == null) {
                node = head.next;
                head.next = null;
                cur = head;
            }
        }
        return root;
    }
}
