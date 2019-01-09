/**
 * 37. Sudoku Solver
 * https://leetcode.com/problems/sudoku-solver/
 * 啊啊啊，没有做出来，之前的思路是寻找每个可能值最少的试探，但是在处理时非常麻烦
 * 这种方法是常见套路：简单地说思路就是循环处理子问题，对于每个格子，带入不同的9个数，然后判合法，如果成立就递归继续，结束后把数字设回空
 * 大部分NP问题的都是可以这个方法
 * todo review这种常见思路
 */
public class LeetCode37 {

    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9)
            return;
        helper(board, 0, 0);
    }

    private boolean helper(char[][] board, int i, int j) {
        if (j >= 9)
            return helper(board, i + 1, 0);
        if (i == 9) {
            return true;
        }
        if (board[i][j] == '.') {
            for (int k = 1; k <= 9; k++) {
                board[i][j] = (char) (k + '0');
                if (isValid(board, i, j)) {
                    if (helper(board, i, j + 1))
                        return true;
                }
                // 最后把值改回去是重点呀
                board[i][j] = '.';
            }
        } else {
            return helper(board, i, j + 1);
        }
        return false;
    }

    private boolean isValid(char[][] board, int i, int j) {
        for (int k = 0; k < 9; k++) {
            if (k != j && board[i][k] == board[i][j])
                return false;
        }
        for (int k = 0; k < 9; k++) {
            if (k != i && board[k][j] == board[i][j])
                return false;
        }
        for (int row = i / 3 * 3; row < i / 3 * 3 + 3; row++) {
            for (int col = j / 3 * 3; col < j / 3 * 3 + 3; col++) {
                if ((row != i || col != j) && board[row][col] == board[i][j])
                    return false;
            }
        }
        return true;
    }
}