/**
 * 5. Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 * 最初用递归实现，但是时间复杂度太高
 * 动态规划
 */
public class LeetCode5 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }
        boolean[][] flags = new boolean[len][len];
        for (int i = 0; i < len ; i ++){
            for (int j = 0; j< len; j ++) {
                if (i >= j ) {
                    flags[i][j] = true;
                } else {
                    flags[i][j] = false;
                }
            }
        }
        int max = 1;
        String result = s.substring(0,1);
        for (int i = 1; i<len; i++) {
            for (int j = 0; j+i<len; j++) {
                if (s.charAt(j) != s.charAt(j+i)) {
                    flags[j][j+i] = false;
                } else {
                    if (flags[j+1][j+i-1]) {
                        flags[j][j+i] = true;
                        if (i + 1> max) {
                            max = i +1;
                            result = s.substring(j, j+i+1);
                        }
                    } else {
                        flags[j][j+i] = false;
                    }
                }
            }
        }
        return result;
    }

}

/*
* 优秀方案
* 分奇数和偶数讨论
*/

/*class Solution {
    private int start,maxLen;
    public String longestPalindrome(String s) {
        if(s.length() < 2){
            return s;
        }
        // 当时也想到这种思路，但是没有分析清楚怎么分奇数和偶数讨论
        for(int i = 0;i < s.length()-1;i++){
            isReverse(s,i,i);//判断奇数个的答案
            isReverse(s,i,i+1);//判断偶数个的答案
        }
        return s.substring(start,start+maxLen);
    }
    public void isReverse(String s,int j,int k){
        while(j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)){
            j--;
            k++;
        }
        if(maxLen < k-j-1){
            start = j+1;
            maxLen = k-j-1;
        }
    }
}*/
