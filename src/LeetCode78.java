import java.util.ArrayList;
import java.util.List;

/**
 * 78. Subsets
 * https://leetcode.com/problems/subsets/
 * 有了77题的铺垫，这道题就简单了很多，只是在加到结果列表时删除了判断条件，具体可以与77题对比
 */
public class LeetCode78 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> sub = new ArrayList<>();
        add(0, sub, nums);
        return result;
    }

    private void add(int start, List<Integer> sub, int[] nums) {
        /**此处删除判断条件都加一遍，与77题的不同*/
        result.add(new ArrayList<>(sub));
        for (int i = start; i < nums.length; i++) {
            sub.add(nums[i]);
            add(i + 1, sub, nums);
            sub.remove(sub.size() - 1);
        }
    }

}
