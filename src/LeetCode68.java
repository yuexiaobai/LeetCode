import java.util.ArrayList;
import java.util.List;

/**
 * 68. Text Justification
 * https://leetcode.com/problems/text-justification/
 * 此题较难，提交了好多次才过，难点如下：
 * 1、中间单次后面加空格，最后一个不加，因为加不加空格需要分情况，所以不如都加，然后让maxWidth+1
 * 2、注意end的初始值为-1，为0的话，如果只有一个字符串的时候可能有问题，如["a"], maxWidth =2
 * 3、注意各处判断条件是否合理
 * todo 难点1需要重点记下
 */
public class LeetCode68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int len = 0;
        List<String> results = new ArrayList<>();
        int start = 0, end = -1;
        maxWidth += 1;
        for (int i = 0; i < words.length; i++) {
            int tempLen = words[i].length() + 1;
            len += tempLen;
            if (len > maxWidth) {
                end = i - 1;
                len -= tempLen;
                results.add(constructString(words, start, end, len, maxWidth));
                start = i;
                len = tempLen;
            } else if (len == maxWidth) {
                end = i;
                results.add(constructString(words, start, end, len, maxWidth));
                start = i + 1;
                len = 0;
            }
        }
        if (end < words.length - 1) {
            StringBuilder builder = new StringBuilder();
            for (int i = start; i < words.length - 1; i++) {
                builder.append(words[i]);
                builder.append(" ");
            }
            builder.append(words[words.length - 1]);
            int l = maxWidth - 1 - builder.length();
            for (int i = 0; i < l; i++) {
                builder.append(" ");
            }
            results.add(builder.toString());
        }
        return results;
    }

    private String constructString(String[] words, int start, int end, int width, int maxWidth) {
        int space = end - start;
        int c = 0;
        int other = 0;
        if (space != 0) {
            c = (maxWidth - width) / space;
            other = (maxWidth - width) % space;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = start; i < end; i++) {
            builder.append(words[i]);
            for (int j = 0; j <= c; j++) {
                builder.append(" ");
            }
            if ((i - start) < other) {
                builder.append(" ");
            }
        }
        builder.append(words[end]);

        int l = maxWidth - 1 - builder.length();
        for (int i = 0; i < l; i++) {
            builder.append(" ");
        }

        return builder.toString();
    }
}
