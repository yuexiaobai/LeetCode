/**
 * 111. Minimum Depth of Binary Tree
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * 需要注意只有一个左子树或者一个右子树的情况，这种不是叶子节点，需要过滤掉
 */
public class LeetCode111 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return (int) getminDepth(root);
    }

    private long getminDepth(TreeNode root) {
        // 这种情况是只有一个左子树或者一个右子树，需要过滤，不是叶子节点
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        // 既没有左子树也没有右子树的是叶子节点，正常返回
        if (root.left == null && root.right == null) {
            return 1;
        }
        long left = getminDepth(root.left) + 1;
        long right = getminDepth(root.right) + 1;
        return left > right ? right : left;
    }
}
