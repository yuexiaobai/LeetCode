/**
 * 48. Rotate Image
 * https://leetcode.com/problems/rotate-image/
 * 这种题目也是有规律可循，先旋转最外圈，然后在旋转里圈
 * 注意不需要判断长度的奇偶性，因为即便是奇数，最中心的一个数不需要旋转
 * 这个思路好记，但是对应坐标的转换可以尝试记一下，因为真的不是特别好一次写对
 */
public class LeetCode48 {
    public void rotate(int[][] matrix) {
        if (matrix.length <= 1) {
            return;
        }
        int len = matrix.length;
        int temp = 0;
        for (int i = 0; i < len / 2; i++) {
            int bottom = len - 1 - i, right = len - 1 - i;
            for (int j = i; j < bottom; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[bottom - (j - i)][i];
                matrix[bottom - (j - i)][i] = matrix[bottom][right - (j - i)];
                matrix[bottom][right - (j - i)] = matrix[j][right];
                matrix[j][right] = temp;
            }
            System.out.println("#############################");
            for (int m = 0; m < len; m++) {
                for (int n = 0; n < len; n++) {
                    System.out.print(matrix[m][n] + "   ");
                }
                System.out.println("");
            }
        }

    }
}
