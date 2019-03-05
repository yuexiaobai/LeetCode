/**
 * 67. Add Binary
 * https://leetcode.com/problems/add-binary/
 */
public class LeetCode67 {
    public String addBinary(String a, String b) {
        int lena = a.length();
        int lenb = b.length();
        int max = lena > lenb ? lena : lenb;
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= max; i++) {
            int indexa = lena - i;
            int indexb = lenb - i;
            int valuea = 0, valueb = 0;
            if (indexa >= 0) {
                valuea = a.charAt(indexa) - '0';
            }
            if (indexb >= 0) {
                valueb = b.charAt(indexb) - '0';
            }
            if (valuea + valueb + carry > 1) {
                builder.insert(0, valuea + valueb + carry - 2);
                carry = 1;
            } else {
                builder.insert(0, valuea + valueb + carry);
                carry = 0;
            }
        }
        if (carry == 1) {
            builder.insert(0, "1");
        }
        return builder.toString();
    }
}
