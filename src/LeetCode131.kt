/**
 * 131. Palindrome Partitioning
 * https://leetcode.com/problems/palindrome-partitioning/
 * 求解所有答案的经典方法：递归+循环
 * 经典方法也有点忘了，想了好久
 * TODO 复习！复习！复习！
 */
class LeetCode131 {
    var result: MutableList<List<String>> = mutableListOf()
    fun partition(s: String): List<List<String>> {
        getPartition(s, 0, mutableListOf())
        return result
    }

    private fun getPartition(s: String, start: Int, container: MutableList<String>) {
        if (start == s.length) {
            result.add(ArrayList(container))
            return
        }
        for (index in start until s.length) {
            val substr = s.substring(start, index + 1)
            if (isPalindrome(substr)) {
                container.add(substr)
                getPartition(s, index + 1, container)
                container.removeAt(container.size - 1)
            }
        }
    }

    private fun isPalindrome(s: String): Boolean {
        if (s.length == 1) {
            return true
        }
        var start = 0
        var end = s.length - 1
        while (end >= start) {
            if (s[start] == s[end]) {
                start++
                end--
            } else {
                return false
            }
        }
        return true
    }
}