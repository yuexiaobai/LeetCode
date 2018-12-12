/**
 * 12. Integer to Roman
 * https://leetcode.com/problems/integer-to-roman/description/
 * 最初思路：对10进行循环除法，替换成罗马符号，之后对9个，5个，4个连续的符号进行替换
 */
public class LeetCode12 {
    public String intToRoman(int num) {
        if (num == 0) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        String[] ss = new String[]{
                "I", "V", "X", "L", "C", "D", "M"
        };
        int[] sn = new int[]{
                1, 5, 10, 50, 100, 500, 1000
        };

        int pos = sn.length - 1;
        while (pos >= 0) {
            if (num >= sn[pos]) {
                int n = num / sn[pos];
                for (int i = 0; i < n; i++) {
                    builder.append(ss[pos]);
                }
                num -= sn[pos] * n;
            }
            pos = pos - 2;
        }
        String temp = builder.toString();
        for (int i = 0; i < ss.length; i++) {
            String nine = constructString(ss[i], 9);
            String four = constructString(ss[i], 4);
            String five = constructString(ss[i], 5);
            if (temp.contains(nine) && i + 2 < ss.length) {
                String repalcenine = ss[i] + ss[i + 2];
                temp = temp.replace(nine, repalcenine);
            } else if (temp.contains(five) && i + 1 < ss.length) {
                String repalcefive = ss[i + 1];
                temp = temp.replace(five, repalcefive);
            } else if (temp.contains(four) && i + 1 < ss.length) {
                String repalcefour = ss[i] + ss[i + 1];
                temp = temp.replace(four, repalcefour);
            }
        }

        return temp;
    }

    public String constructString(String s, int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(s);
        }
        return builder.toString();
    }
}

/**
 * 对包含9和4的规则都提前算出来，大幅度提高效率
 * 有穷的规则可以计算出来
 */

//class Solution {
//    int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
//    String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
//
//    public String intToRoman(int num) {
//        StringBuilder sb = new StringBuilder();
//        for(int i=0;i<values.length;i++){
//            while(num>=values[i]){
//                sb.append(strs[i]);
//                num-=values[i];
//            }
//        }
//        return sb.toString();
//    }
//}
