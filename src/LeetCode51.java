import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 51. N-Queens
 * https://leetcode.com/problems/n-queens/
 * 做倒是做出来了，np问题，暴力求解，回溯法，但是算法整体效率太低
 * 优秀算法解析博客https://www.tianmaying.com/tutorial/LC51
 * 自己算法慢的原因是判断当前位置是否正确比较慢，每次都是n*n的时间
 * 优秀算法遍历每行的n个位置，用三个数组分别记录当前列，当前左斜线，
 * 当前右斜线是否已经有数字，所以判断起来更快速
 *
 * 收获：可以用多个标志来记录状态，只要在后面恢复即可  line106~109
 */
public class LeetCode51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        putQueen(n, new ArrayList<>(), result);
        return result;
    }

    public void putQueen(int n, List<Integer> list, List<List<String>> result) {
        if (!checkNQueens(list)) {
            return;
        } else if (list.size() == n) {
            List<String> strs = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int pos = list.get(i);
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (pos == j) {
                        builder.append("Q");
                    } else {
                        builder.append(".");
                    }
                }
                strs.add(builder.toString());
            }
            result.add(strs);
            return;
        }
        for (int i = 0; i < n; i++) {
            list.add(i);
            putQueen(n, list, result);
            list.remove(list.size() - 1);
        }
    }

    public boolean checkNQueens(List<Integer> list) {
        if (list.isEmpty()) {
            return true;
        }
        Set<Integer> set = new HashSet<>(list);
        if (set.size() < list.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i == j)
                    continue;
                if (Math.abs(list.get(i) - list.get(j)) == Math.abs(i - j)) {
                    return false;
                }
            }
        }
        return true;
    }
}




// 优秀算法
/*
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if(n<=0) return result;
        char[][] board = new char[n][n];
        for(int i=0;i<n; i++) {
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
        helper(result, n, 0, board, new boolean[n], new boolean[2*n], new boolean[2*n]);
        return result;
    }

    private void helper(List<List<String>> result, int n, int row, char[][] subResult, boolean[] colSet, boolean[] leftSet, boolean[] rightSet) {
        if(row >= n) {
            result.add(generateList(subResult));
            return;
        }

        for(int j=0; j<n; j++) {
            if(colSet[j] || leftSet[row+j] || rightSet[j-row+n]) {
                continue;
            }
            subResult[row][j] = 'Q';
            colSet[j] = true;
            leftSet[row+j] = true;
            rightSet[j-row+n] = true;
            helper(result, n, row+1, subResult, colSet, leftSet, rightSet);
            rightSet[j-row+n] = false;
            leftSet[row+j] = false;
            colSet[j] = false;
            subResult[row][j] = '.';
        }
    }

    private List<String> generateList(char[][] charArray) {
        List<String> result = new ArrayList<>(charArray.length);
        for(int i=0;i<charArray.length; i++) {
            String value = new String(charArray[i]);
            result.add(value);
        }
        return result;
    }
}
*/
