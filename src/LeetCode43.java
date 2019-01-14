/**
 * 43. Multiply Strings
 * https://leetcode.com/problems/multiply-strings/
 * 没有做出来呀，还是记一下这个算法吧
 * 算法就是取自于竖式相乘，用第二个数的每一位与第一个数每一位相乘，用数组记录，然后计算进位
 * todo 大数相乘很常用，记录一下
 */
public class LeetCode43 {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))
            return "0";

        int len1 = num1.length(), len2 = num2.length();
        int[] digits = new int[len1 + len2];

        for(int i = len1 - 1; i >= 0; i--) {
            for(int j = len2 - 1; j >= 0; j--) {
                int prod = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                digits[i + j + 1] += prod;
            }
        }
        for(int i = len1 + len2 - 2; i >= 0; i--) {
            digits[i] += digits[i + 1] / 10;
            digits[i + 1] = digits[i + 1] % 10;
        }
        int startingIdx = 0;
        if(digits[0] == 0)
            startingIdx = 1;
        StringBuilder result = new StringBuilder();
        for (int i = startingIdx; i < digits.length; i++) {
            result.append(digits[i]);
        }
        return result.toString();
    }
}
