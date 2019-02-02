/**
 * 58. Length of Last Word
 * https://leetcode.com/problems/length-of-last-word/
 * 只要记得先去掉开头结尾的空格再处理就可以了
 * 从后往前循环比分割字符串更快
 */
public class LeetCode58 {
    public int lengthOfLastWord(String s) {
        if (s == null) {
            return 0;
        }
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }
        String[] ss = s.split(" ");
        return ss[ss.length - 1].length();
    }
}


/*class Solution {
    public int lengthOfLastWord(String s) {
        int ct=0;
        s = s.trim(); //delete the " " from the start and end of string
        for(int i=s.length();i>0;i--)
            if(s.charAt(i-1) != ' ')
                ct++;
            else break;
        return ct;
    }
}*/
