import java.util.*;

/**
 * 77. Combinations
 * https://leetcode.com/problems/combinations/
 * 虽然做出来了，但是费了很长时间
 * 这是一个经典的递归算法，已经出现了好多次
 * 1、先添加进list
 * 2、改变start进行递归
 * 3、remove list中的最后一个
 * 4、在递归开始判断是否需要结束
 */
public class LeetCode77 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || k > n) {
            return result;
        }

        List<Integer> nums = new ArrayList<>();
        add(1, n, k, nums);
        return result;
    }

    public void add(int start, int end, int k, List<Integer> nums) {
        if (nums.size() == k) {
            result.add(new ArrayList<>(nums));
            return;
        }

        for (int i = start; i <= end; i++) {
            nums.add(i);
            add(i + 1, end, k, nums);
            nums.remove(nums.size() - 1);
        }
    }

}
