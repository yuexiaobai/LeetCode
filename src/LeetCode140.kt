/**
 * 140. 单词拆分 II
 * https://leetcode-cn.com/problems/word-break-ii/
 * 题目很难，但是解法很通用，记忆化的深度优先搜索
 * 答案参考 https://blog.csdn.net/fuxuemingzhu/article/details/85089275
 * todo 记录一下，记忆化深度优先搜索算法
 */
class LeetCode140 {
    fun wordBreak(s: String, wordDict: List<String>): List<String> {
        return dfs(s, HashSet(wordDict), mutableMapOf())
    }

    private fun dfs(
        s: String,
        wordDict: Set<String>,
        map: MutableMap<String, List<String>>
    ): List<String> {
        if (map.containsKey(s)) {
            return map[s]!!
        }
        if (s == ("")) {
            return listOf("")
        }
        val list = mutableListOf<String>()
        for (word in wordDict) {
            if (s.startsWith(word)) {
                val rest = dfs(s.substring(word.length), wordDict, map)
                for (str in rest) {
                    val sep = if (str.isEmpty()) "" else " "
                    list.add("$word$sep$str")
                }
            }
        }
        map[s] = list
        return list
    }
}


