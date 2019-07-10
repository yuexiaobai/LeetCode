import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. Subsets II
 * https://leetcode.com/problems/subsets-ii/
 * 这道题的难点在于去重，排序和判相等都想到了，没有想到的是判断i > start
 * 这个思路：1、排序 2、判断(i > start && nums[i - 1] == nums[i])去重
 * todo 得重点记一下
 */
public class LeetCode90 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        getSets(nums, list, 0);
        return result;
    }

    public void getSets(int[] nums, List<Integer> list, int start) {
        result.add(new ArrayList<>(list));
        if (start >= nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i - 1] == nums[i]) {
                continue;
            }
            list.add(nums[i]);
            getSets(nums, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
