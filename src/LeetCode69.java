/**
 * 69. Sqrt(x)
 * https://leetcode.com/problems/sqrtx/
 * 这是借鉴了牛顿迭代法求解开方运算
 * 具体讲解的博客https://blog.csdn.net/huangfei711/article/details/79664300
 * todo 开方运算有特定的算法，牛顿迭代法需要记忆一下
 */
public class LeetCode69 {
    public int mySqrt(int x) {
        long resutSqrt = x;
        while (resutSqrt * resutSqrt > x) {
            resutSqrt = (resutSqrt + x/resutSqrt) / 2;
        }
        return (int)resutSqrt;
    }
}
