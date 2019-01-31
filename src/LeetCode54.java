import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix
 * https://leetcode.com/problems/spiral-matrix/
 * 这题目看着不难，但是特殊的case很多，自己还真是想不全面
 * 主要有以下两种特殊case
 * OOOOO  OOO
 * OXXXO  OXO
 * OOOOO  OXO
 *        OXO
 *        OOO
 * 这两种case需要特殊处理，还有最特殊的方形的中心，也需要特殊处理
 * 所以，正常算法只处理left < right && top < bottom的情况，其他的情况特殊处理
 * TODO 记录以下这种算法
 */
public class LeetCode54 {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> ans = new ArrayList<>();

        if (matrix == null || matrix.length == 0) {
            return ans;
        }

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (left < right && top < bottom) {
            for (int i = left; i < right; i++) {
                ans.add(matrix[top][i]);
            }
            for (int i = top; i < bottom; i++) {
                ans.add(matrix[i][right]);
            }
            for (int i = right; i > left; i--) {
                ans.add(matrix[bottom][i]);
            }
            for (int i = bottom; i > top; i--) {
                ans.add(matrix[i][left]);
            }

            top++;
            bottom--;
            left++;
            right--;
        }

        if (bottom == top && left < right) {
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
        }
        if (bottom > top && left == right) {
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][left]);
            }
        }
        if (bottom == top && left == right) {
            ans.add(matrix[top][left]);
        }

        return ans;
    }

}
