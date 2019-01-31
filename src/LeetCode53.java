/**
 * 53. Maximum Subarray
 * https://leetcode.com/problems/maximum-subarray/
 * 虽然做对了，但是这个算法在之前的题目出现过，想了一会才想起来
 * 算法：如果当前和>0说明可以继续向下传递，如果当前和<0,则把和置为0，重新计算，用max记录出现的最大的和
 */
public class LeetCode53 {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > max) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}



