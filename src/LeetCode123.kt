import kotlin.math.max

/**
 * 123. 买卖股票的最佳时机 III
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 * 这道题目太难了，可以采用常规的动态规划，但是思路也很绕
 * 利用状态机可以轻松解决，但是很难想到，思路可以参考
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/yi-ge-tong-yong-fang-fa-tuan-mie-6-dao-gu-piao-wen/
 */
class LeetCode123 {
    fun maxProfit(prices: IntArray): Int {
        if (prices.isEmpty()) {
            return 0
        }
        var s1: Int = -prices[0]
        var s2: Int = Int.MIN_VALUE
        var s3: Int = Int.MIN_VALUE
        var s4: Int = Int.MIN_VALUE
        for (i in 1 until prices.size) {
            s1 = max(s1, -prices[i]); //买入价格更低的股
            s2 = max(s2, s1 + prices[i]); //卖出当前股，或者不操作
            s3 = max(s3, s2 - prices[i]); //第二次买入，或者不操作
            s4 = max(s4, s3 + prices[i]); //第二次卖出，或者不操作
        }
        return max(0, s4)
    }
}