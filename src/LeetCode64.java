/**
 * 64. Minimum Path Sum
 * https://leetcode.com/problems/minimum-path-sum/
 * 动态规划，开始想使用一个一维数组来实现，但是在提交的时候发现，
 * 一维数组可能导致当前路径是否可达的问题，例如
 * [[1,2],
 * [5,6],
 * [1,1]]
 * 可能在计算的时候出现第一步是1，第二步是1+2，但是第三步的时候没有选6，选择的1，导致最后结果是1+2+1+1=5
 * 感觉是和63题弄混了，错误使用了63题的方法
 */
public class LeetCode64 {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int[][] result = new int[m][n];
        result[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i + j > 0) {
                    int top = Integer.MAX_VALUE, left = Integer.MAX_VALUE;
                    if (i > 0) {
                        top = grid[i][j] + result[i - 1][j];
                    }
                    if (j > 0) {
                        left = grid[i][j] + result[i][j - 1];
                    }
                    result[i][j] = top > left ? left : top;
                }
            }
        }
        return result[m - 1][n - 1];
    }
}
