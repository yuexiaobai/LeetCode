import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 145. 二叉树的后序遍历
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * 后续遍历比前序和中序要复杂一点，也是三种方法，可以参考144题
 * 之前一直用栈来实现，参考了官方题解后，发现可以用逆向的先序遍历实现，不需要标志位
 * 参考https://leetcode-cn.com/problems/binary-tree-postorder-traversal/solution/er-cha-shu-de-hou-xu-bian-li-by-leetcode/
 * 而且思路特别顺，只能说666，好好梳理一下二叉树相关的题目，写一篇博客记录一下。
 */
public class LeetCode145 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<Integer> list = new ArrayList<>();
    Stack<TreeNode> stack = new Stack();

    public List<Integer> postorderTraversal(TreeNode root) {
        TreeNode node = root;
        TreeNode last = root;
        while (node != null || !stack.empty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.peek();
                if (node.right == null || node.right == last) {
                    list.add(node.val);
                    stack.pop();
                    last = node;
                    node = null;
                } else {
                    node = node.right;
                }
            }
        }
        return list;
    }
}
