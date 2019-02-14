/**
 * 62. Unique Paths
 * https://leetcode.com/problems/unique-paths/
 * 这道题纯数学题，从m+n-2个步骤中选出n-1个向下的，m-1个向右的，典型排列组合问题
 * 但是还是碰到了很多问题
 * 1、组合C的计算公式记错了，详见https://baike.baidu.com/item/%E6%8E%92%E5%88%97%E7%BB%84%E5%90%88/706498
 * 2、大数会溢出，不能直接求阶乘
 * 所以在计算的时候要先计算出(m+n-2)!/max!的结果，这个等于从m+n-2乘到m+n-2-max，避免了(m+n-2)!阶乘的溢出
 * 只计算min!，一般不会溢出
 * 思路很简单，但是由于遇到了以上两个问题，也写了很久
 */
public class LeetCode62 {
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int count = m + n - 2;
        int min = m > n ? n - 1 : m - 1;
        if (min <= 0) {
            return 1;
        }
        long temp1 = 1;
        for (int i = 0; i < min; i++) {
            temp1 *= count;
            count--;
        }
        long temp2 = 1;
        for (int i = 1; i <= min; i++) {
            temp2 *= i;
        }
        return (int) (temp1 / temp2);
    }

}
