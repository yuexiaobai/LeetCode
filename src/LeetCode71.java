import java.util.Stack;

/**
 * 71. Simplify Path
 * https://leetcode.com/problems/simplify-path/
 * 首先使用/对路径进行分离，.可以不用处理，字母如栈，..出栈，最后组装即可
 * 一次通过
 */
public class LeetCode71 {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        if (dirs == null || dirs.length == 0) {
            return "/";
        }
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < dirs.length; i++) {
            String dir = dirs[i];
            if (dir.equals(".")) {
                continue;
            } else if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                if (!dir.equals("")) {
                    stack.push(dir);
                }
            }
        }
        StringBuilder builder = new StringBuilder("");
        while (!stack.isEmpty()) {
            String dir = stack.pop();
            builder.insert(0, "/" + dir);
        }
        String result = builder.toString();
        if (result.equals("")) {
            return "/";
        }
        return result;
    }
}
