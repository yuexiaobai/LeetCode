/**
 * 65. Valid Number
 * https://leetcode.com/problems/valid-number/
 * 这道题采用了比较取巧的方式，直接采用了java的api，效率不算好，还是需要重点记忆一下正常的判断逻辑
 * 判断逻辑+/-  数字  小数点 数字 e  +/- 数字
 */
public class LeetCode65 {
    public boolean isNumber(String s) {
        for(char c : s.trim().toCharArray()) {
            if (!((c >= 48 && c <= 57) || c == 'e' || c == '.' || c == '+' || c == '-')) {
                return false;
            }
        }
        try {
            Double.parseDouble(s);
            return true;
        } catch(Exception e) {
            return false;
        }
    }
}

/**
 * 优秀算法
 */
/*
class Solution {
    public boolean isNumber(String s) {
        if(s == null)
            return false;
        String str = s.trim();
        if(str.length() == 0)
            return false;
        int i = 0;
        int n = str.length();
        //checking +/- sign
        if(i < n && (str.charAt(i) == '+' || str.charAt(i) == '-'))
            i++;
        //checking numbers before dot
        boolean isDigit = false;
        while(i < n && Character.isDigit(str.charAt(i))) {
            i++;
            isDigit = true;
        }
        //checking numbers after dot and before e
        if(i < n && str.charAt(i) == '.') {
            i++;
            while(i < n && Character.isDigit(str.charAt(i))) {
                i++;
                isDigit = true;
            }
        }

        if(i < n && isDigit && str.charAt(i) == 'e') {
            i++;
            isDigit = false;
            if(i < n && (str.charAt(i) == '+' || str.charAt(i) == '-'))
                i++;

            while(i < n && Character.isDigit(str.charAt(i))) {
                i++;
                isDigit = true;
            }
        }
        return i == n && isDigit;
    }
}
*/
