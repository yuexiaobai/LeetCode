/**
 * 115. Distinct Subsequences
 * https://leetcode.com/problems/distinct-subsequences/
 * 这道题很经典，开始感觉可以用回溯法解决，但是又稍有不同，思考了很久也没有解决
 * TODO 以后无法快速解决的问题就可以思考动态规划，一定要有这种思路
 */
public class LeetCode115 {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int j = 0; j < s.length() + 1; j++) dp[0][j] = 1;
        for (int i = 1; i < t.length() + 1; i++) {
            for (int j = 1; j < s.length() + 1; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                else dp[i][j] = dp[i][j - 1];
            }
        }
        return dp[t.length()][s.length()];
    }
}
