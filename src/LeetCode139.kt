/**
 * 139. 单词拆分
 * https://leetcode-cn.com/problems/word-break/
 * 思路不难，但是需要注意边界
 */
class LeetCode139 {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val length = s.length
        val results = BooleanArray(length + 1) {
            it == 0
        }
        for (i in 1 until length + 1) {
            for (j in 0 until i) {
                if (results[j] && wordDict.contains(s.substring(j, i))) {
                    results[i] = true
                    break
                }
            }
        }
        return results[length]
    }
}