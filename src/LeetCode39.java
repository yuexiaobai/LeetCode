/**
 * 39. Combination Sum
 * https://leetcode.com/problems/combination-sum/
 * 优秀的算法使用了递归，而且对数组进行了排序，排序的话可以减少部分不必要的循环
 * 这种题有套路，一般都是要写一个函数实现递归
 */

import java.util.ArrayList;
import java.util.List;

public class LeetCode39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        int start = 0, sum = 0;
        List<Integer> list = new ArrayList<>();
        while (true) {
            if (start == candidates.length) {
                if (list.isEmpty()) {
                    break;
                } else {
                    start = list.remove(list.size() - 1) + 1;
                    sum = sum - candidates[start - 1];
                    continue;
                }
            }
            if (sum + candidates[start] < target) {
                sum += candidates[start];
                list.add(start);
            } else if (sum + candidates[start] == target) {
                list.add(start);
                List<Integer> temp = new ArrayList<>();
                for (int pos : list) {
                    temp.add(candidates[pos]);
                    // 貌似去掉日志从60ms降到了16ms
                    //System.out.print(candidates[pos]);
                }
                //System.out.println("");
                result.add(temp);
                if (list.size() > 0) {
                    start = list.remove(list.size() - 1) + 1;
                }
            } else {
                start++;
            }
        }
        return result;
    }
}

/*
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return result;
        int[] nums = removeDuplicates(candidates);
        dfs(nums, 0, target, new ArrayList<Integer>(), result);
        return result;

    }
    private void dfs(int[] nums, int startIndex, int remainTarget, List<Integer> combination, List<List<Integer>> result) {
        if (remainTarget == 0) {
            result.add(new ArrayList<Integer>(combination));
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (remainTarget < nums[i]) break;
            combination.add(nums[i]);
            dfs(nums, i, remainTarget - nums[i], combination, result);
            combination.remove(combination.size() - 1);
        }
    }
    private int[] removeDuplicates(int[] candidates) {
        Arrays.sort(candidates);
        int index = 0;
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] != candidates[index]) {
                candidates[++index] = candidates[i];
            }
        }
        int[] nums = new int[index + 1];
        for (int i = 0; i < index + 1; i++) {
            nums[i] = candidates[i];
        }
        return nums;
    }
}*/
