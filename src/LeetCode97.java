/**
 * 97. Interleaving String
 * https://leetcode.com/problems/interleaving-string/
 * 只要是遇到字符串的子序列或是匹配问题直接就上动态规划 Dynamic Programming，其他的都不要考虑
 * 一般来说字符串匹配问题都是更新一个二维 dp 数组，核心就在于找出状态转移方程
 * 递归超时，没有做出来，这也是经典算法，需要加强记忆
 * todo 及时复习
 */
public class LeetCode97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) return false;
        // 包含一个空串，所以需要len + 1的长度
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        //初始化边界
        dp[0][0] = true;
        for (int i = 1; i <= s1.length(); i++) {
            dp[i][0] = s3.charAt(i - 1) == s1.charAt(i - 1) ? dp[i - 1][0] : false;
        }

        for (int i = 1; i <= s2.length(); i++) {
            dp[0][i] = s3.charAt(i - 1) == s2.charAt(i - 1) ? dp[0][i - 1] : false;
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                char v3 = s3.charAt(i + j - 1);
                boolean v1 = v3 == s1.charAt(i - 1) ? dp[i - 1][j] : false;
                boolean v2 = v3 == s2.charAt(j - 1) ? dp[i][j - 1] : false;
                dp[i][j] = v1 || v2;
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
