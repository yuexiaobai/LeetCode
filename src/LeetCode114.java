/**
 * 114. Flatten Binary Tree to Linked List
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * 自己想出来的算法思路: 如果当前节点有左子树，那么就交换左右子树，然后找到右子树之后一个节点，把左子树接到后面，效率一般，不是最优算法
 * 其实这道题就是一个先序遍历，然后用一个prev节点把所有遍历到的节点拼起来就可以了
 * TODO 可以参考最优算法递归时怎么记录节点
 */
public class LeetCode114 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            TreeNode right = root.right;
            root.right = root.left;
            root.left = right;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode node = root;
        while (node.right != null) {
            node = node.right;
        }
        node.right = root.left;
        root.left = null;
    }
}

// 最优算法，先序遍历
/*class Solution {
    TreeNode prev;
    public void flatten(TreeNode root) {
        prev = new TreeNode(-1);

        dfs(root);

    }

    private void dfs(TreeNode node) {
        if(node == null) return;
        prev.right = node;
        prev = node;
        TreeNode l = node.left;
        TreeNode r = node.right;
        node.left = null;
        if(l != null) dfs(l);
        if(r != null) dfs(r);
    }
}*/

