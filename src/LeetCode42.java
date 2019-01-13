/**
 * 42. Trapping Rain Water
 * https://leetcode.com/problems/trapping-rain-water/
 * 虽然又想又改了很久，但是一次就通过了，哈哈
 * 思路：找到数组中的最大的值所在的位置max，max左边的只需要从左到右的与前一个位置的值相等即可
 * 同样，max右边的只需要从右到左的与前一个位置的值相同即可，然后计算差值即为所求
 *
 * 优秀方法思路更清奇，其实不需要单独寻找最大值，可以分别更新左右两边，左边大更新右边，右边大更新左边
 * TODO 其实从自己的想法推断出优秀算法也不难，可以review一下这种思路
 */
public class LeetCode42 {
    public int trap(int[] height) {
        int result = 0;
        if (height == null || height.length <= 2) {
            return result;
        }
        int maxpos = getMaxPos(height);
        for (int i = 0; i < maxpos - 1; i++) {
            if (height[i + 1] < height[i]) {
                result += height[i] - height[i + 1];
                height[i + 1] = height[i];
            }
        }

        for (int j = height.length - 1; j > maxpos; j--) {
            if (height[j - 1] < height[j]) {
                result += height[j] - height[j - 1];
                height[j - 1] = height[j];
            }
        }

        return result;
    }

    private int getMaxPos(int[] nums) {
        int pos = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[pos]) {
                pos = i;
            }
        }
        return pos;
    }
}


/*
class Solution {
    public int trap(int[] height) {
        int max = 0, lmax = 0, rmax = 0, l = 0, r = height.length - 1;
        while (l < r){
            lmax = Math.max(lmax, height[l]);
            rmax = Math.max(rmax, height[r]);
            if (lmax < rmax){
                if (height[l] < lmax) max += (lmax - height[l]);
                l++;
            }
            else{
                if (height[r] < rmax) max += (rmax - height[r]);
                r--;
            }
        }
        return max;
    }
}
*/
