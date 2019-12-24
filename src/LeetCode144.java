import java.util.ArrayList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * 之前只知道二叉树的遍历有递归和栈+循环，空间复杂度是O(n)
 * 莫里斯遍历可以用O(1)的空间复杂度实现二叉树的先序和中序遍历，后序遍历稍微有点复杂
 * 参考博客：https://www.cnblogs.com/anniekim/archive/2013/06/15/morristraversal.html
 * TODO: 莫里斯遍历,稍后总结一下二叉树相关的算法代码包括递归遍历、循环+栈，莫里斯等
 */
public class LeetCode144 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        TreeNode node = root, pre = null;
        while(node != null) {
            if(node.left == null) {
                list.add(node.val);
                node = node.right;
            } else {
                pre = node.left;
                while(pre.right != null && pre.right != node) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = node;
                    list.add(node.val);
                    node = node.left;
                } else {
                    pre.right = null;
                    node = node.right;
                }
            }
        }
        return list;
    }
}
