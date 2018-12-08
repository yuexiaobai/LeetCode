/**
 * 28. Implement strStr()
 * https://leetcode.com/problems/implement-strstr/description/
 * 简单题目，增加有效的判断可以减少时间复杂度
 */
public class LeetCode28 {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        } else if (haystack == null || haystack.length() < needle.length()) {
            return -1;
        }
        for (int i = 0; i < haystack.length(); i++) {
            // 此处判断可以减少部分循环,当剩余长度小于needle长度时退出
            if (haystack.length() -i < needle.length()) {
                return -1;
            }
            int cur = 0;
            while (cur < needle.length() && i + cur < haystack.length()
                    && haystack.charAt(i + cur) == needle.charAt(cur)) {
                cur++;
            }
            if (cur == needle.length()) {
                return i;
            }
        }
        return -1;
    }
}
