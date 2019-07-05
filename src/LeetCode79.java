/**
 * 79. Word Search
 * https://leetcode.com/problems/word-search/
 * 这道题自己写了绝大部分出来，但是在循环部分有问题，有点没理清循环部分的逻辑，参考了博客
 */
public class LeetCode79 {

    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0 || board.length * board[0].length < word.length()) {
            return false;
        }
        boolean[][] flag = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (check(board, i, j, word, 0, flag)) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean check(char[][] board, int row, int column, String word, int index, boolean[][] flag) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || column < 0 || column >= board[row].length || flag[row][column]) {
            return false;
        }
        if (board[row][column] == word.charAt(index)) {
            index++;
            flag[row][column] = true;
            if (check(board, row, column + 1, word, index, flag)
                    || check(board, row, column - 1, word, index, flag)
                    || check(board, row - 1, column, word, index, flag)
                    || check(board, row + 1, column, word, index, flag)) {
                return true;
            } else {
                flag[row][column] = false;
            }
        }
        return false;
    }
}
