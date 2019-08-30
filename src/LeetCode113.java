import java.util.ArrayList;
import java.util.List;

/**
 * 113. Path Sum II
 * https://leetcode.com/problems/path-sum-ii/
 * 类似于之前字符串的操作，先加入列表中，然后迭代，完成后在删除
 * TODO 做了很久才做出来，要记住这种求全部符合要求的数据的通用方法
 */
public class LeetCode113 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        helper(root, sum);
        return result;
    }

    private void helper(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            result.add(new ArrayList<>(list));
        } else {
            helper(root.left, sum - root.val);
            helper(root.right, sum - root.val);
        }
        list.remove(list.size() - 1);
    }
}
