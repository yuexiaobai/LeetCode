import java.util.Stack;

/**
 * 99. Recover Binary Search Tree
 * https://leetcode.com/problems/recover-binary-search-tree/
 * 没有做出来，解法参考https://www.jianshu.com/p/65c3b61c4e17
 * 需要看下先序遍历、中序遍历、后序遍历的循环以及递归实现方法，做到随手可以写出来
 */
public class LeetCode99 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode swap1 = null;
        TreeNode swap2 = null;
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (pre != null && pre.val >= cur.val) {
                if (swap1 == null) {
                    swap1 = pre;
                    swap2 = cur;
                } else {
                    swap2 = cur;
                }
            }
            pre = cur;
            cur = cur.right;
        }

        int tmp = swap1.val;
        swap1.val = swap2.val;
        swap2.val = tmp;
    }
}
