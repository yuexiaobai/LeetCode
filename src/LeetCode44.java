/**
 * 44. Wildcard Matching
 * https://leetcode.com/problems/wildcard-matching/
 * 借鉴了LeetCode10的递归方法，但是在字符串特别长的时候，时间复杂度太高，
 * 而且虽然记得LeetCode10的思路，但是在写代码时依然有很多边界问题搞不清楚
 * 可以使用动态规划方法，最优方法貌似不是动态规划
 * TODO 对比LeetCode10分析最优方法和动态规划递归的实现与边界
 */

// 自己的方法，貌似效率太低了
public class LeetCode44 {
    public boolean isMatch(String s, String p) {
        if (!s.equals("") && p.equals("")) {
            return false;
        }
        if (s.equals("") && (p.equals("") || p.equals("*"))) {
            return true;
        }
        p = resetpstring(p);
        return isMatchByPosition(s, 0, p, 0);
    }

    public String resetpstring(String p) {
        int len = p.length();
        boolean flag = false;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (!(p.charAt(i) == '*' && flag)) {
                builder.append(p.charAt(i));
            }
            if (p.charAt(i) == '*' && !flag) {
                flag = true;
            } else if (p.charAt(i) != '*' && flag) {
                flag = false;
            }
        }
        return builder.toString();
    }

    public boolean isMatchByPosition(String s, int sstart, String p, int pstart) {
        int slen = s.length();
        int plen = p.length();
        if (sstart == slen && pstart == plen) {
            return true;
        } else if (pstart == plen && sstart < slen) {
            return false;
        }
        char pchar = p.charAt(pstart);
        if (sstart >= slen) {
            if (pchar == '*') {
                return isMatchByPosition(s, sstart, p, pstart + 1);
            } else {
                return false;
            }
        } else {
            if (pchar != '*') {
                if (pchar == s.charAt(sstart) || pchar == '?') {
                    return isMatchByPosition(s, sstart + 1, p, pstart + 1);
                } else {
                    return false;
                }
            } else {
                return isMatchByPosition(s, sstart, p, pstart + 1) || isMatchByPosition(s, sstart + 1, p, pstart);
            }
        }
    }
}

// 动态规划方法，效率中等，但是可以记录，然后去算法导论认真学习一下动态规划
/*class Solution {
    public boolean isMatch(String s, String p) {
        char S[]=s.toCharArray();
        char P[]=p.toCharArray();
        int n=S.length,m=P.length;
        boolean dp[][]=new boolean[m+1][n+1];
        dp[0][0]=true;
        int start=0; //当前对于每行搜索的时候起始位置的标示，一定不用搜索的位置就是每当Pattern遇到一个非*的地方就可以加1
        for(int i=1;i<=m;i++){ //pattern
            if(P[i-1]=='*') {
                dp[i][0] = dp[i-1][0];
                for(int j=1;j<=n;j++)
                    dp[i][j] = dp[i-1][j-1] || dp[i][j-1] || dp[i-1][j];
            }
            else{
                start++;
                for(int j=start;j<=n;j++){
                    if(P[i-1]=='?' || P[i-1]==S[j-1]){
                        if(dp[i-1][j-1] == true) //可以访问
                            dp[i][j]=true;
                    }
                }
            }
        }
        return dp[m][n];
    }

}*/


// 最优方法,这部分代码先不做具体研究了，等着回归的时候，对比LeetCode10做分析
/*
class Solution {
    public boolean isMatch(String str, String pattern) {
        int s = 0, p = 0, match = 0, starIdx = -1;
        while (s < str.length()){
            // advancing both pointers
            if (p < pattern.length()  && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
                s++;
                p++;
            }
            // * found, only advancing pattern pointer
            else if (p < pattern.length() && pattern.charAt(p) == '*'){
                starIdx = p;
                match = s;
                p++;
            }
            // last pattern pointer was *, advancing string pointer
            else if (starIdx != -1){
                p = starIdx + 1;
                match++;
                s = match;
            }
            //current pattern pointer is not star, last patter pointer was not *
            //characters do not match
            else return false;
        }

        //check for remaining characters in pattern
        while (p < pattern.length() && pattern.charAt(p) == '*')
            p++;

        return p == pattern.length();
    }
}
*/
