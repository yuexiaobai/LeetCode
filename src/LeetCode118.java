import java.util.ArrayList;
import java.util.List;

/**
 * 118. Pascal's Triangle
 * https://leetcode.com/problems/pascals-triangle/
 * 简单题目
 */
public class LeetCode118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows <= 0) {
            return result;
        }

        List<Integer> preview = null;
        for (int len = 1; len <= numRows; len++) {
            List<Integer> list = new ArrayList<>();
            for (int index = 0; index < len; index++) {
                if (index == 0 || index == len - 1) {
                    list.add(1);
                } else {
                    if (preview != null) {
                        list.add(preview.get(index) + preview.get(index - 1));
                    }
                }
            }
            preview = list;
            result.add(list);
        }
        return result;
    }
}
