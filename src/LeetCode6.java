/**
 * 6. ZigZag Conversion
 * https://leetcode.com/problems/zigzag-conversion/description/
 * 找规律，要考虑好边界，首先考虑边界
 *
 * 虽然做出来了，但是边界判断不清晰，速度慢
 */

public class LeetCode6 {
    public String convert(String s, int numRows) {
        if (s.length() <= 2 || numRows == 1) {
            return s;
        }
        // 每行的字数个数
        int line = 2 * (numRows - 1);
        // 一共的行数
        int num = s.length() / line;
        if (s.length() % line > 0) {
            num++;
        }
        StringBuilder builder = new StringBuilder("");
        int pos;
        for (int i = 0; i < numRows; i++) {
            pos = i;
            for (int j = 1; j <= num; j++) {
                if (pos < s.length()) {
                    builder.append(s.charAt(pos));
                }
                if (i != 0 && i != numRows - 1) {
                    int next = pos + line - i * 2;
                    if (next < s.length()) {
                        builder.append(s.charAt(next));
                    }
                }
                pos += line;
            }
        }

        return builder.toString();
    }
}

/**
 * 更快的方案，思路一致，但是把StringBuilder替换成了分配好的char数组
 */

/*class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0)
            return "";
        if (numRows == 1)
            return s;

//         StringBuilder[] sb = new StringBuilder[numRows];
//         int n = 2*numRows -2;
//         for (int i = 0; i < numRows; i++){
//             sb[i] = new StringBuilder("");
//         }
//         for(int i = 0; i < s.length(); i++){
//             int index = i % n;
//             index = index < numRows ? index : n - index;
//             sb[index].append(s.charAt(i));
//         }

//         for (int i = 1; i < numRows; i++){
//             sb[0].append(sb[i]);
//         }

//         return sb[0].toString();
// }

        char[] res = new char[s.length()];
        int step = 2*numRows - 2;
        int count = 0;
        for(int i = 0; i < numRows; i++){
            int interval = step - 2*i;
            for (int j = i; j < s.length(); j += step){
                res[count] = s.charAt(j);
                count++;
                if (interval > 0 && interval < step
                        && j+interval < s.length()){
                    res[count] = s.charAt(j+interval);
                    count++;
                }
            }
        }
        return new String(res);
    }
}*/
