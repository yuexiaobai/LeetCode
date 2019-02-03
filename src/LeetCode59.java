/**
 * 59. Spiral Matrix II
 * https://leetcode.com/problems/spiral-matrix-ii/
 * 费老了劲才做对
 * 这题思路很清晰，但是要做对还是很难，主要是坐标对应的关系比较难找对
 * 最近做了好几道类似的题目，还是做不好，得总结一下
 * todo 记录一下
 */
public class LeetCode59 {
    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            return null;
        }
        int[][] result = new int[n][n];
        int tl = 0, br = n - 1;
        int start = 0;
        int count = 0;
        int step = n - 1;
        while (tl < br) {
            start = count + 1;
            for (int i = tl; i < br; i++) {
                //左侧
                result[tl][i] = start;
                result[i][br] = start + step;
                result[br][br - (i - tl)] = start + step * 2;
                result[br - (i - tl)][tl] = start + step * 3;
                start++;
            }
            count += 4 * (br - tl + 1) - 4;
            tl++;
            br--;
            step = br - tl;
        }
        if (tl == br) {
            result[tl][br] = n * n;
        }
        return result;
    }
}
