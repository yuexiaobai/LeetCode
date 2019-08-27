import java.util.HashMap;
import java.util.Map;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * 参照105题的解法，这道题思路就比较简单了
 */
public class LeetCode106 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int[] minorder, mpostorder;
    int index = 0;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        minorder = inorder;
        mpostorder = postorder;
        int len = postorder.length;
        index = len - 1;
        for (int i = 0; i < len; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = helper(0, len);
        return root;
    }

    private TreeNode helper(int start, int end) {
        if (start == end) {
            return null;
        }
        int val = mpostorder[index];
        TreeNode node = new TreeNode(val);
        int pos = map.get(val);
        index--;
        node.right = helper(pos + 1, end);
        node.left = helper(start, pos);
        return node;
    }
}
