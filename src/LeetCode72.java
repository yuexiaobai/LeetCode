/**
 * 72. Edit Distance
 * https://leetcode.com/problems/edit-distance/
 * 经典算法请看http://www.cnblogs.com/pandora/archive/2009/12/20/levenshtein_distance.html
 */
public class LeetCode72 {
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length(), cost;
        int dp[][] = new int[n + 1][m + 1];
        //初始化
        for (int i = 0; i <= n; i++)
            dp[i][0] = i;
        for (int i = 0; i <= m; i++)
            dp[0][i] = i;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                cost = word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1;
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + cost);
            }
        }
        return dp[n][m];
    }
}
