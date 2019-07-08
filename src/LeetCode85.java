import java.util.Stack;

/**
 * 85. Maximal Rectangle
 * https://leetcode.com/problems/maximal-rectangle/
 * 难度很大，没做出来，但是看完了简单的思路，在回忆84题时，写getMaxArea方法都没有写对。。
 * 也没有复用heights数据提高速度
 * 最后参考博客https://blog.csdn.net/linhuanmars/article/details/24444491
 */
public class LeetCode85 {
    int result = 0;

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int row = matrix.length, column = matrix[0].length;
        int[] heights = new int[column];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                // 并不需要每次重新计算，只需要置位0或者在原来基础上+1
                heights[c] = matrix[r][c] == '0' ? 0 : heights[c] + 1;
            }
            // 参考84题递增栈解法
            getMaxArea(heights);
        }
        return result;
    }

    private void getMaxArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= heights.length; i++) {
            int cell = (i == heights.length) ? -1 : heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] > cell) {
                int height = heights[stack.pop()];
                // 计算宽度需要理解
                int widht = stack.isEmpty() ? i : i - stack.peek() - 1;
                result = result > height * widht ? result : height * widht;
            }
            stack.push(i);
        }
    }

}
