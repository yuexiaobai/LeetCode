import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * 借鉴102提的解法后思路很简单，但是处理起来还是错了好多次
 * TODO 复习
 */
public class LeetCode103 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<List<Integer>> levels = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return levels;
        }
        int level = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            if (levels.size() == level) {
                levels.add(new ArrayList<>());
            }
            int size = queue.size();
            List<Integer> list = levels.get(level);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (level % 2 == 0) {
                    list.add(node.val);
                } else {
                    list.add(0, node.val);
                }
            }
            level++;
        }
        return levels;
    }
}
