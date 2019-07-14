import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. Binary Tree Inorder Traversal
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 * 二叉树先序、中序、后序遍历讲解blog
 * https://blog.csdn.net/qq_33243189/article/details/80222629
 * 中序遍历非递归实现方案：
 * https://www.jianshu.com/p/00e623dd2169
 */
public class LeetCode94 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<Integer> result = new ArrayList<>();

    // 递归实现
    /*public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return result;
        }
        if (root.left != null) {
            inorderTraversal(root.left);
        }
        result.add(root.val);
        if (root.right != null) {
            inorderTraversal(root.right);
        }
        return result;
    }*/

    // 循环实现
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return result;
        }

        Stack<TreeNode> aux = new Stack<TreeNode>();
        TreeNode node = root;//node指向待处理节点

        while (node != null || !aux.isEmpty()) {
            while (node != null) {
                //当前节点不为null，将当前节点入栈等到该节点的左子树全部处理完后在处理当前节点
                aux.add(node);
                node = node.left;//先处理左孩子节点
            }
            TreeNode temp = aux.pop();
            result.add(temp.val);//node没有左孩子，则输出当前node节点
            node = temp.right;//处理node的右子树
        }
        return result;
    }

}
