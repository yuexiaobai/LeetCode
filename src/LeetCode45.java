/**
 * 45. Jump Game II
 * https://leetcode.com/problems/jump-game-ii/
 * 自己的方法一次做对了，采用动态规划，但是效率不高
 * 最优算法采用了贪心算法，每次寻找在接下来两次中走的最远的作为下一跳。
 */
public class LeetCode45 {
    public int jump(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return 0;
        }
        int[] lens = new int[len];
        lens[0] = 0;
        for (int i = 1; i < len; i++) {
            lens[i] = Integer.MAX_VALUE;
        }
        for (int index = 0; index < len; index++) {
            int val = nums[index];
            int step = lens[index];
            for (int i = 1; i <= val & i + index < len; i++) {
                if (step + 1 < lens[i + index]) {
                    lens[i + index] = step + 1;
                }
            }
        }
        return lens[len - 1];
    }
}

/*
class Solution {
    public int jump(int[] nums) {
        int cur = 0;
        int next = 0;
        int count = 0;
        while (cur < nums.length-1) {
            if (cur + nums[cur] >= nums.length - 1)
                return count + 1;
            int end = cur + nums[cur];
            int tmp = 0;
            for (int i = cur; i <= end; i++) {
                if (i + nums[i] > tmp) {
                    tmp = i + nums[i];
                    next = i;
                }
            }
            count++;
            cur = next;
        }
        return count;
    }
}
*/
