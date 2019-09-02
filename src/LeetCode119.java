import java.util.ArrayList;
import java.util.List;

/**
 * 119. Pascal's Triangle II
 * https://leetcode.com/problems/pascals-triangle-ii/
 * 题比较简单，但是要注意细节，以后写简单算法要争取一次过
 */
public class LeetCode119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = null;
        List<Integer> preview = null;
        for (int i = 0; i <= rowIndex; i++) {
            int len = i + 1;
            result = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                if (j == 0 || j == len - 1) {
                    result.add(1);
                } else {
                    if (preview != null) {
                        result.add(preview.get(j) + preview.get(j - 1));
                    }
                }
            }
            preview = result;
        }
        return result;
    }
}
