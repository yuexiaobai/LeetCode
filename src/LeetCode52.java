/**
 * 52. N-Queens II
 * https://leetcode.com/problems/n-queens-ii/
 * 直接借鉴了51题中的优秀算法，并加以改造，完美实现，效率很高
 * 具体思路参考51题
 */
public class LeetCode52 {
    int count = 0;
    public int totalNQueens(int n) {
        if (n < 0 || (n > 1 && n < 4)) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        helper(n, 0, new boolean[n], new boolean[2 * n], new boolean[2 * n]);
        return count;
    }

    private void helper(int n, int row, boolean[] colSet, boolean[] leftSet, boolean[] rightSet) {
        if (row >= n) {
            count++;
        }

        for (int j = 0; j < n; j++) {
            if (colSet[j] || leftSet[row + j] || rightSet[j - row + n]) {
                continue;
            }
            colSet[j] = true;
            leftSet[row + j] = true;
            rightSet[j - row + n] = true;
            helper(n, row + 1, colSet, leftSet, rightSet);
            rightSet[j - row + n] = false;
            leftSet[row + j] = false;
            colSet[j] = false;
        }
    }
}
