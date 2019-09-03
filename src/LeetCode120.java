import java.util.List;

/**
 * 120. Triangle
 * https://leetcode.com/problems/triangle/
 * 这道题比较灵性了，虽然做出来，基本思路也对，但是自己的思路是从上到下遍历，
 * 所以多出来了很多不必要的判断和字段
 * 最优化方案采用从底部到顶部的遍历，具体讲解可以参考
 * https://leetcode-cn.com/problems/triangle/solution/di-gui-ji-yi-hua-sou-suo-zai-dao-dp-by-crsm/
 */
public class LeetCode120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int len = triangle.size();
        int[] sums = new int[len];
        int distance = Integer.MAX_VALUE;
        int preview = 0;
        for (List<Integer> list : triangle) {
            int size = list.size();
            distance = Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                if (i == 0) {
                    preview = sums[i];
                    sums[i] = sums[i] + list.get(i);
                } else if (i == size - 1) {
                    sums[i] = preview + list.get(i);
                } else {
                    int min = sums[i] > preview ? preview : sums[i];
                    preview = sums[i];
                    sums[i] = list.get(i) + min;
                }
                distance = distance < sums[i] ? distance : sums[i];
            }
        }
        return distance;

        // 最优算法，自底部向顶部循环
        /*public int minimumTotal(List<List<Integer>> triangle) {
            int row = triangle.size();
            int[] minlen = new int[row+1];
            for (int level = row-1;level>=0;level--){
                for (int i = 0;i<=level;i++){   //第i行有i+1个数字
                    minlen[i] = Math.min(minlen[i], minlen[i+1]) + triangle.get(level).get(i);
                }
            }
            return minlen[0];
        }*/
    }
}
