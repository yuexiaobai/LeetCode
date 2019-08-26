/**
 * 104. Maximum Depth of Binary Tree
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class LeetCode104 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int max = 1;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getDepth(root.left, 2);
        getDepth(root.right, 2);
        return max;
    }

    private void getDepth(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        max = depth > max ? depth : max;
        getDepth(root.left, depth + 1);
        getDepth(root.right, depth + 1);
    }
}
