import java.util.Arrays;

/**
 * 41. First Missing Positive
 * https://leetcode.com/problems/first-missing-positive/
 * 优秀算法把每个正数value移动到对应的value-1位置上，然后循环看位置和和值是否对应
 * 第一个不对应的即为要求的数
 */
public class LeetCode41 {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        Arrays.sort(nums);
        int pos = 0;
        int value = 1;
        while (pos < nums.length) {
            if (nums[pos] < value) {
                pos++;
            } else if (nums[pos] == value) {
                pos++;
                value++;
            } else {
                break;
            }
        }
        return value;
    }
}


/*
class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        int n = nums.length;
        while (i < n) {

            if (nums[i] > 0 && nums[i] < n && nums[nums[i]-1] != nums[i])
                swap(nums, i, nums[i]-1);
            else
                i++;
        }
        i = 0;
        while(i < nums.length && nums[i] == i+1) i++;
        return i+1;
    }

    private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

}
*/
