import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 30. Substring with Concatenation of All Words
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 * 注意返回值说明，题目返回[]，不是null
 * 暴力方法解决，效率太低 faster than 5.26% of Java online submissions
 * 优秀算法核心思路：1、之前得到的符合题目的数据不需要全部清除，只需清除从start到start+wl之间的数据，然后count-1
 * 2、外层循环wl,以每次wl的步长看是否符合条件
 */
public class LeetCode30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || words== null || words.length == 0
                || s.length() < words[0].length() * words.length) {
            return list;
        }
        int len = words[0].length();
        for (int i = 0; i <= s.length() - len * words.length; i++) {
            int start = i;
            List<String> container = new ArrayList<>(Arrays.asList(words));
            while (start < s.length()) {
                if (start + len <= s.length()) {
                    String sub = s.substring(start, start + len);
                    if (container.contains(sub)) {
                        container.remove(sub);
                        if (container.isEmpty()) {
                            list.add(i);
                            break;
                        } else {
                            start += len;
                        }
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return list;
    }

}



/*
class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> res = new LinkedList<>();
        if (L.length == 0 || S.length() < L.length * L[0].length())   return res;
        int N = S.length();
        int M = L.length; // *** length
        int wl = L[0].length();
        Map<String, Integer> map = new HashMap<>(), curMap = new HashMap<>();
        for (String s : L) {
            if (map.containsKey(s))   map.put(s, map.get(s) + 1);
            else                      map.put(s, 1);
        }
        String str = null, tmp = null;
        for (int i = 0; i < wl; i++) {
            int count = 0;  // remark: reset count
            int start = i;
            for (int r = i; r + wl <= N; r += wl) {
                str = S.substring(r, r + wl);
                if (map.containsKey(str)) {
                    if (curMap.containsKey(str))   curMap.put(str, curMap.get(str) + 1);
                    else                           curMap.put(str, 1);

                    if (curMap.get(str) <= map.get(str))    count++;
                    while (curMap.get(str) > map.get(str)) {
                        tmp = S.substring(start, start + wl);
                        curMap.put(tmp, curMap.get(tmp) - 1);
                        start += wl;

                        //the same as https://leetcode.com/problems/longest-substring-without-repeating-characters/
                        if (curMap.get(tmp) < map.get(tmp)) count--;

                    }
                    if (count == M) {
                        res.add(start);
                        tmp = S.substring(start, start + wl);
                        curMap.put(tmp, curMap.get(tmp) - 1);
                        start += wl;
                        count--;
                    }
                }else {
                    curMap.clear();
                    count = 0;
                    start = r + wl;//not contain, so move the start
                }
            }
            curMap.clear();
        }
        return res;
    }
}
*/
