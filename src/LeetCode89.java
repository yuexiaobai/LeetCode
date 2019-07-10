import java.util.ArrayList;
import java.util.List;

/**
 * 89. Gray Code
 * https://leetcode.com/problems/gray-code/
 * 思路正确，但是还要注意边界条件
 * 优秀算法循环次数更少，更简洁
 */
public class LeetCode89 {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        if (n == 0) {
            return result;
        }
        int pow = 0;
        for (int i = 1; i < Math.pow(2, n); i++) {
            int step = (int) Math.pow(2, pow);
            if (i == step) {
                pow++;
                for (int j = step - 1; j >= 0; j--) {
                    result.add(result.get(j) + step);
                }
            }
        }
        return result;
    }
}

/**
 * 优秀算法更简洁，循环次数更少
 */
/*
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList();
        result.add(0);
        if(n==0) return result;

        for(int i=0; i<n; i++)
        {
            int k = result.size();
            for(int j=k-1; j>= 0;j--)
            {
                result.add(result.get(j)| 1<<i);
            }
        }
        return result;
    }
}
*/

