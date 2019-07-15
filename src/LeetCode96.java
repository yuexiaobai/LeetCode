/**
 * 96. Unique Binary Search Trees
 * https://leetcode.com/problems/unique-binary-search-trees/
 * 开始借鉴了LeetCode95的思路，发现超时，然后采用了动态规划
 * 发现题做多了，思路比较清晰了
 */
public class LeetCode96 {
    public int numTrees(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                nums[i] += nums[j] * nums[i - 1 - j];
            }
        }
        return nums[n];
    }
}
