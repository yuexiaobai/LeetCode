/**
 * 151. 翻转字符串里的单词
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * 这题不难，主要是不清楚split方法对多个空格分隔的返回，返回""
 */
public class LeetCode151 {
    public String reverseWords(String s) {
        String result = "";
        s = s.trim();
        String[] arr = s.split(" ");
        int length = arr.length;
        for(int i = length -1;i>=0;i--) {
            if(arr[i].equals("")) {
                continue;
            }
            result += arr[i] + " ";
        }
        return result.equals("") ? "":result.substring(0, result.length() -1);
    }
}
