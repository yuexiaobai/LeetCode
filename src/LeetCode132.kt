/**
 * 132. Palindrome Partitioning II
 * https://leetcode.com/problems/palindrome-partitioning-ii/
 * 并没有想出方案来，最后参考了答案
 * 答案可以参考https://leetcode-cn.com/problems/palindrome-partitioning-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-3-8/
 * TODO 不知道为什么动态规划的题目很难做出来，多做点试试
 */
class LeetCode132 {
    fun minCut(s: String): Int {
        val length = s.length
        val nums: Array<IntArray> = Array(length) { outer ->
            IntArray(length) { inner ->
                if (inner == outer) 1 else 0
            }
        }
        var times = IntArray(length + 1) {
            it - 1
        }
        for (i in 0 until length) {
            for (j in 0 until i + 1) {
                if (s[i] == s[j] && (i - j <= 1 || nums[j + 1][i - 1] == 1)) {
                    nums[j][i] = 1
                    if (times[i + 1] > times[j] + 1)
                        times[i + 1] = times[j] + 1
                }
            }
        }
        return times[length]
    }
}