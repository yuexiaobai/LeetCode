/**
 * 101. Symmetric Tree
 * https://leetcode.com/problems/symmetric-tree/
 * todo 可以尝试循环方法
 */
public class LeetCode101 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        return isSymmetric(left, right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        else if (left != null && right != null && left.val == right.val) {
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }
        return false;
    }
}
