import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 49. Group Anagrams
 * https://leetcode.com/problems/group-anagrams/
 * 这道题的精髓在于转成字符排序后再转成字符串，就可以存hashmap了
 * 当时只想到了转成字符数组和排序，没有再进一步转成字符串，所以在比较是否相等的时候比较耗时
 * TODO 字符串 转 字符数组 排序 转字符串， 处理相同字符组成的不同字符串的通用方法
 */
public class LeetCode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        int len = strs.length;
        if (len == 0) {
            return result;
        }
        List<char[]> characters = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            String s = strs[i];
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            int pos = checkChars(characters, chars);
            if (pos != -1) {
                List<String> list = result.get(pos);
                list.add(s);
            } else {
                characters.add(chars);
                List<String> list = new ArrayList<>();
                list.add(s);
                result.add(list);
            }
        }
        return result;
    }

    public int checkChars(List<char[]> list, char[] chars) {
        for (int i = 0; i < list.size(); i++) {
            char[] array = list.get(i);
            if (array.length == chars.length) {
                if (array.length == 0) {
                    return i;
                }
                for (int j = 0; j < array.length; j++) {
                    if (array[j] != chars[j]) {
                        break;
                    }
                    if (j == array.length - 1)
                        return i;
                }
            }
        }
        return -1;
    }
}

/**
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> results = new ArrayList<>();

        if(strs.length == 0) return results;

        HashMap<String, List<String>> map = new HashMap<>();

        for(String s: strs)
        {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String sSort = new String(arr);

            if(map.containsKey(sSort))
            {
                map.get(sSort).add(s);
            }
            else
            {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(sSort, list);
            }

        }

        for(String key: map.keySet())
        {
            List<String> list = map.get(key);
            results.add(list);
        }

        return results;

    }
}
 */