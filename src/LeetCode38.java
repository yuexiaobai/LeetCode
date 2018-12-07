import java.util.ArrayList;
import java.util.List;

/**
 * 38. Count and Say
 * https://leetcode.com/problems/count-and-say/description/
 * 动态规划，记录从1到n所有的结果，根据n-1的结果生成n
 */
public class LeetCode38 {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        List<String> list = new ArrayList<>();
        list.add("1");
        for (int i = 2; i <= n; i++) {
            String last = list.get(i - 2);
            String cur = "";
            for (int j = 0; j < last.length(); ) {
                int count = 1;
                while (j+count < last.length() && last.charAt(j) == last.charAt(j+count)) {
                    count++;
                }
                cur += count + "" + last.charAt(j);
                j = j+count;
            }
            list.add(cur);
        }
        return list.get(n - 1);
    }
}


/*
 * 因为n只取决于n-1的结果，所以不需要全部记录
 */
/*
class Solution {
    public String countAndSay(int n) {
    // 只需要一个字段s记录即可
        String s = "1";
        for(int i = 1; i < n; i++){
            s = countIdx(s);
        }
        return s;
    }

    public String countIdx(String s){
        StringBuilder sb = new StringBuilder();
        // 对于常用的数据定义一次，不要用s.charAt代替c会更快
        char c = s.charAt(0);
        int count = 1;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == c){
                count++;
            }
            else
            {
                sb.append(count);
                sb.append(c);
                c = s.charAt(i);
                count = 1;
            }
        }
        sb.append(count);
        sb.append(c);
        return sb.toString();
    }
}
*/
