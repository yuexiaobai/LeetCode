/**
 * 70. Climbing Stairs
 * https://leetcode.com/problems/climbing-stairs/
 * 这题想了很久，动态规划的公式没想明白
 * 如果有n步，那么最后一步可能是1，也可能是2，所以是两种情况的和
 * 推导公式： results[n] = results[n - 2] + results[n - 1];
 */
public class LeetCode70 {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] results = new int[n];
        results[0] = 1;
        results[1] = 2;
        for (int i = 3; i <= n; i++) {
            results[i - 1] = results[i - 3] + results[i - 2];
        }
        return results[n - 1];
    }
}
