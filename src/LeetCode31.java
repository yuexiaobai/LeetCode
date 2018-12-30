/**
 * 31. Next Permutation
 * https://leetcode.com/problems/next-permutation/\
 * 思路：找到当前值比后续值小的第一个位置，和后面比它大但是值最接近的位置换，此时后面的仍然是递减序列，然后重排序为递增序列即可，
 * 如果数组全部为递减序列，则整个改为递增
 * 貌似优秀算法也是这个思路，只是在边界判断有小的不一致，但是时间快很多
 */
public class LeetCode31 {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int len = nums.length;
        int start = 0;
        int temp;
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                int pos = getNextNumber(nums, i + 1, nums[i]);
                temp = nums[i];
                nums[i] = nums[pos];
                nums[pos] = temp;
                start = i + 1;
                break;
            }
        }
        int end = len - 1;
        while (start <= end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

    }

    public int getNextNumber(int[] nums, int start, int value) {
        int pos = start;
        for (int i = start + 1; i < nums.length; i++) {
            // 本身是递减的，所以只需要找到最后一个大于特定值的就可以了
            if (nums[i] > value) {
                pos = i;
            }
        }
        return pos;
    }
}
