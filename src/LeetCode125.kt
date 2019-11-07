/**
 * 125. 验证回文串
 * https://leetcode-cn.com/problems/valid-palindrome/
 * 比较简单的题目用于练习kotlin
 */
class LeetCode125 {
    fun isPalindrome(s: String): Boolean {
        if (s == "") {
            return true
        }
        val str: String =
            s.filter { it in '0'..'9' || it in 'a'..'z' || it in 'A'..'Z' }.run { toLowerCase() }
        var start = 0
        var end = str.length - 1
        while (start < end) {
            if (str[start++] != str[end--]) {
                return false
            }
        }
        return true
    }
}