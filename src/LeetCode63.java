/**
 * 63. Unique Paths II
 * https://leetcode.com/problems/unique-paths-ii/
 * 一直思考排列组合的解决方法，没有做出来呀
 * 动态规划方法的记录的数组可以是一维，也可以二维，一维更省空间
 * 博客地址：http://www.cnblogs.com/grandyang/p/4353680.html
 * TODO 还是得系统看下动态规划，而且以后写代码直接在LeetCode上写吧，锻炼一下
 */
public class LeetCode63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        int[] res = new int[obstacleGrid[0].length];
        res[0] = 1;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    res[j] = 0;
                } else {
                    if (j > 0)
                        res[j] += res[j - 1];
                }
            }
        }
        return res[obstacleGrid[0].length - 1];
    }
}
