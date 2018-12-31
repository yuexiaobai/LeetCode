import java.util.Stack;

/**
 * 32. Longest Valid Parentheses
 * https://leetcode.com/problems/longest-valid-parentheses/
 * 没做出来，主要因为以下两点
 * 1、按照惯性思维，开始在Stack里放得char，没有位置信息，看到博客答案后恍然大悟呀
 * 2、从25行到32行之间的逻辑没屡清楚，特别是30行，用Stack中上一个位置元素来计算长度
 * 参考博客 http://www.cnblogs.com/grandyang/p/4424731.html
 *
 * 开始也考虑了动态规划的思路，但是也没有考虑清楚
 *
 * TODO 最快算法是动态规划，如下面所示  https://segmentfault.com/a/1190000003481194
 * TODO 还是找时间系统看下算法导论的动态规划吧
 */
public class LeetCode32 {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char left = '(';
        int len = s.length();
        int start = 0, max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == left) {
                stack.push(i);
            } else {
                if (stack.empty()) {
                    start = i + 1;
                } else {
                    stack.pop();
                    if (stack.empty()) {
                        max = max > i - start + 1 ? max : i - start + 1;
                    } else {
                        max = max > i - stack.peek() ? max : i - stack.peek();
                    }
                }
            }

        }
        return max;
    }
}


/**
 * java 最快算法
 */
/*
class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0)
            return 0;

        int [] dp = new int [s.length()];
        int max = 0;

        for(int i = s.length() - 2;i >= 0;i--) {
            if(s.charAt(i) == '(') {
                int j = i + dp[i + 1] + 1;

                if(j < s.length() && s.charAt(j) == ')') {
                    dp[i] = dp[i + 1] + 2;
                    // 这行是精髓
                    if(j < s.length() - 1)
                        dp[i] += dp[j + 1];
                }

                max = Math.max(max, dp[i]);
            }
        }

        return max;
    }
}*/
