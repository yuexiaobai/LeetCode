/**
 * 112. Path Sum
 * https://leetcode.com/problems/path-sum/
 * 也是注意叶子节点的定义，需要注意只有一个左子树或者一个右子树的情况，这种不是叶子节点，需要过滤掉
 */
public class LeetCode112 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == sum) {
            return true;
        }
        int val = sum - root.val;
        return hasPathSum(root.left, val) || hasPathSum(root.right, val);
    }
}
