/**
 * 130. Surrounded Regions
 * https://leetcode.com/problems/surrounded-regions/
 * 没有什么思路，参考了答案详见
 * https://leetcode-cn.com/problems/surrounded-regions/solution/bfsdi-gui-dfsfei-di-gui-dfsbing-cha-ji-by-ac_pipe/
 * todo 多复习，总结思路
 */
class LeetCode130 {
    fun solve(board: Array<CharArray>): Unit {
        val row = board.size
        if (row <= 2) {
            return
        }
        val column = board[0].size
        if (column <= 2) {
            return
        }
        for (i in 0 until row) {
            for (j in 0 until column) {
                val isEdge = i == 0 || j == 0 || i == row - 1 || j == column - 1
                if (isEdge && board[i][j] == 'O') {
                    dfs(board, i, j)
                }
            }
        }
        for (i in 0 until row) {
            for (j in 0 until column) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X'
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O'
                }
            }
        }
        println(board.toString())
    }

    private fun dfs(board: Array<CharArray>, i: Int, j: Int) {
        if (i < 0 || j < 0 || i >= board.size || j >= board[0].size || board[i][j] == 'X' || board[i][j] == '#') {
            return
        }
        board[i][j] = '#'
        dfs(board, i - 1, j); // 上
        dfs(board, i + 1, j); // 下
        dfs(board, i, j - 1); // 左
        dfs(board, i, j + 1); // 右
    }
}