/**
 * 40. Combination Sum II
 * https://leetcode.com/problems/combination-sum-ii/
 * 优秀的算法使用了递归，而且对数组进行了排序，排序的话可以减少部分不必要的循环
 * 这种题有套路，一般都是要写一个函数实现递归
 * 在做的时候还是不能第一时间想到这个递归到底应该怎么写，最后借鉴了LeetCode39，还是要总结一下这些套路
 * TODO 及时复习
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        dfs(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int[] nums, int startIndex, int remainTarget, List<Integer> combination, List<List<Integer>> result) {
        if (remainTarget == 0) {
            result.add(new ArrayList<Integer>(combination));
            return;
        }
        if (startIndex >= nums.length) {
            return;
        }
        // 不同的地方在于不能startIndex每次+1，并且每次开头不重复
        while (startIndex < nums.length) {
            if (remainTarget < nums[startIndex]) break;
            int num = nums[startIndex];
            combination.add(num);
            dfs(nums, startIndex + 1, remainTarget - num, combination, result);
            combination.remove(combination.size() - 1);
            int i = 1;
            while (startIndex + i < nums.length && nums[startIndex + i] == num) {
                i++;
            }
            startIndex += i;
        }
    }
}
