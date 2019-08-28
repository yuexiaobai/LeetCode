/**
 * 108. Convert Sorted Array to Binary Search Tree
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * 二叉树的递归，注意边界条件就可以了
 */
public class LeetCode108 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return helper(nums, 0, nums.length);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if (start == end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, start, mid);
        node.right = helper(nums, mid + 1, end);
        return node;
    }
}
