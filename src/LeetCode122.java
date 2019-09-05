/**
 * 122. Best Time to Buy and Sell Stock II
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 参考121题的思路，这两道题很有意思，有思路，但是用最好的方法一次做对还有难度
 * 最优方法可以参考
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-ii-by-leetcode/
 * TODO 可以和121题一块经常看看
 */
public class LeetCode122 {
    public int maxProfit(int[] prices) {
        int max = 0, price = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] >= prices[i]) {
                if (price == Integer.MAX_VALUE) {
                    price = prices[i];
                }
            } else {
                if (price != Integer.MAX_VALUE) {
                    max += prices[i] - price;
                    price = Integer.MAX_VALUE;
                }
            }
        }
        if (price != Integer.MAX_VALUE) {
            max += prices[prices.length - 1] - price;
        }
        return max;
    }
}

// 最优方法
/*class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
}*/
