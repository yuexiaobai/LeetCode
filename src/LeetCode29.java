/**
 * 29. Divide Two Integers
 * https://leetcode.com/problems/divide-two-integers/
 * 开始采用每次减去divisor的方法，时间复杂度太高,从博客借鉴这种方法
 * 注意对dividend = Integer.MIN_VALUE时的处理
 * 最优方法与此方法思路一致，可递归，也可循环
 */
public class LeetCode29 {
    public int divide(int dividend, int divisor) {
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        if (ldividend < ldivisor) {
            return 0;
        }
        long result = 0;
        while (ldividend >= ldivisor) {
            long t = ldivisor, p = 1;
            while (ldividend > (t << 1)) {
                t = t << 1;
                p = p << 1;
            }
            result += p;
            ldividend = ldividend - t;
        }

        if ((dividend < 0) ^ (divisor < 0)) {
            result = -result;
        }
        return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result;
    }
}
