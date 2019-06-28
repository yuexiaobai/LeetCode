/**
 * 74. Search a 2D Matrix
 * https://leetcode.com/problems/search-a-2d-matrix/
 * 采用二分查找应该更快
 * 或者变换二维坐标为一维坐标，具体参考https://www.cnblogs.com/grandyang/p/4323301.html
 */
public class LeetCode74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return false;
        }
        if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) {
            return false;
        }
        int row = 0;
        for (; row < m; row++) {
            if (matrix[row][n - 1] >= target) {
                break;
            }
        }
        for (int column = 0; column < n; column++) {
            if (matrix[row][column] == target) {
                return true;
            }
        }
        return false;
    }

}
