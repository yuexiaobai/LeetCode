/**
 * 87. Scramble String
 * https://leetcode.com/problems/scramble-string/
 * 题很难，但是思路正确，只是没有想清楚利用21行for循环
 * 注意判断equals相等返回true
 */
public class LeetCode87 {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        int[] nums = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            nums[s1.charAt(i) - 'a']++;
            nums[s2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                return false;
            }
        }

        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }

            if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i))
                    && isScramble(s1.substring(i), s2.substring(0, s2.length() - i))) {
                return true;
            }
        }
        return false;
    }
}
