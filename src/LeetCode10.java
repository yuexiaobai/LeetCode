/**
 * 10. Regular Expression Matching
 * https://leetcode.com/problems/regular-expression-matching/description/
 * 自己做时思路不清晰，需要多次review当前算法的思路
 * 有递归和动态规划的思路,需要整体学习一下动态规划的思路，算法导论
 */
// todo 没有做出来，需要review
public class LeetCode10 {
    boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        if (p.length() == 1) {
            return (s.length() == 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));
        }
        if (p.charAt(1) != '*') {
            if (s.isEmpty()) return false;
            return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1));
        }
        while (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
            if (isMatch(s, p.substring(2))) return true;
            s = s.substring(1);
        }
        return isMatch(s, p.substring(2));
    }
}

// todo 需要加深理解
// 动态规划的思路，效率更高

/*
class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null){
            return false;
        }
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for(int i = 0; i < p.length(); i++){
            if (p.charAt(i) == '*' && dp[0][i-1]) {
                dp[0][i+1] = true;
            }
        }
        for(int i = 1; i <= s.length(); i++){
            for(int j = 1; j <= p.length(); j++){
                if(s.charAt(i-1) == p.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                if(p.charAt(j-1) == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }
                if(p.charAt(j-1) == '*'){
                    if(p.charAt(j-2) != s.charAt(i-1) && p.charAt(j-2) != '.'){
                        dp[i][j] = dp[i][j-2];
                    }else{
                        dp[i][j] = (dp[i][j-1] || dp[i][j-2]||dp[i-1][j]);
                    }

                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
*/
