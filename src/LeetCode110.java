/**
 * 110. Balanced Binary Tree
 * https://leetcode.com/problems/balanced-binary-tree/
 * 开始的思路是root.left、root.right都是平衡二叉树，并且高度差小于1，
 * 其实只需要计算高度差小于1就可以了并且递归
 * TODO 没做出来，记忆一下求树的高度，也可以参考104题
 */
public class LeetCode110 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    boolean res = true;
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        helper(root);
        return res;
    }
    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left) + 1;
        int right = helper(root.right) + 1;
        if (Math.abs(right - left) > 1) res = false;
        return Math.max(left, right);
    }

}
