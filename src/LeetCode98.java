/**
 * 98. Validate Binary Search Tree
 * https://leetcode.com/problems/validate-binary-search-tree/
 * 思路比较清晰，注意两点边界问题：
 * 1、如果root为null返回true
 * 2、注意处理val为Interger.MAX_VALUE的情况，所以用Long.MIN_VALUE和Long.MAX_VALUE
 */
public class LeetCode98 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValid(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        } else {
            if (min < root.val && max > root.val) {
                return isValid(root.left, min, root.val)
                        && isValid(root.right, root.val, max);
            } else {
                return false;
            }
        }
    }
}
