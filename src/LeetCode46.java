import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations
 * https://leetcode.com/problems/permutations/
 * 研究了很久，其实exchange方法中的基本方式已经记得差不多了，
 * 之前都是删除之后再加上，根据这个想了好久也没办法解决
 * 这次是调换顺序，记录一下
 * 总结博客见
 * https://blog.csdn.net/jacky_chenjp/article/details/66477538#%E6%97%A0%E9%87%8D%E5%A4%8D%E6%95%B0%E5%AD%97%E7%9A%84%E5%85%A8%E6%8E%92%E5%88%97%E6%95%B0
 */
public class LeetCode46 {

    // 最终返回的结果集
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        if (len == 0 || nums == null) return res;

        // 采用前后元素交换的办法，dfs解题
        exchange(nums, 0, len);
        return res;
    }

    public void exchange(int[] nums, int i, int len) {
        // 将当前数组加到结果集中
        if (i == len - 1) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                list.add(nums[j]);
            }
            res.add(list);
            return;
        }
        // 将当前位置的数跟后面的数交换，并搜索解
        for (int j = i; j < len; j++) {
            swap(nums, i, j);
            exchange(nums, i + 1, len);
            swap(nums, i, j);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
