import java.util.ArrayList;
import java.util.List;

/**
 * 95. Unique Binary Search Trees II
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 * 这道题用递归解法思路并不难，但是left和right都可能对应多种方案
 * 与之前数组采用的常用方案不同
 */
public class LeetCode95 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        return getSortTree(1, n);
    }

    private List<TreeNode> getSortTree(int start, int end) {
        List<TreeNode> heads = new ArrayList<>();
        if (start > end || end <= 0) {
            heads.add(null);
            return heads;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = getSortTree(start, i - 1);
            List<TreeNode> rights = getSortTree(i + 1, end);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode head = new TreeNode(i);
                    head.left = left;
                    head.right = right;
                    heads.add(head);
                }
            }
        }
        return heads;
    }
}
