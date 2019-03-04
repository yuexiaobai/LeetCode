/**
 * 66. Plus One
 * https://leetcode.com/problems/plus-one/
 */
public class LeetCode66 {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int[] result = new int[len + 1];
        int add = 1;
        for (int i = len - 1; i >= 0; i--) {
            int temp = digits[i];
            if (temp + add > 9) {
                add = 1;
                result[i] = 0;
                digits[i] = 0;
            } else {
                result[i] = temp + add;
                digits[i] = temp + add;
                return digits;
            }
        }
        if (add == 1) {
            result[0] = 1;
            return result;
        } else {
            return digits;
        }
    }
}
