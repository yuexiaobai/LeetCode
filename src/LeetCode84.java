import java.util.Stack;

/**
 * 84. Largest Rectangle in Histogram
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * 中心扩展法确实可以解决这个问题，但是效率是O(n2)，基本垫底了
 * 递增栈解法，思路详见https://www.cnblogs.com/grandyang/p/4322653.html
 * 第19行-1为了让数组中最后一个数字顺利出栈
 * 递增栈巧妙呀！！！！
 */
class LeetCode84 {
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();  //维护单调递增
        int max = 0;
        for (int i = 0; i <= height.length; i++) {
            int curt = (i == height.length) ? -1 : height[i];
            while (!stack.isEmpty() && curt <= height[stack.peek()]) {    //如果栈顶高度大于当前高度
                int h = height[stack.pop()];		//保存栈顶元素信息
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;		//如果栈已经为空，宽度为i，否则i-s.top()-1
                max = Math.max(max, h * w);
            }
            stack.push(i);				//压入栈中
        }

        return max;
    }

    /**
     * 中心扩展法实现方案
     */
    /*int max = 0;
    public int largestRectangleArea(int[] heights) {
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            int area = getWidth(heights, i) * height;
            if (area > max) {
                max = area;
            }
        }
        return max;
    }

    private int getWidth(int[] heights, int index) {
        int height = heights[index];
        int width = 1;
        for (int i = index - 1; i >= 0; i--) {
            if (heights[i] >= height) {
                width += 1;
            } else {
                break;
            }
        }

        for (int i = index + 1; i < heights.length; i++) {
            if (heights[i] >= height) {
                width += 1;
            } else {
                break;
            }
        }
        return width;
    }*/
}
