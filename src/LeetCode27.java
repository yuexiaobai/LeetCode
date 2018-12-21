/**
 * 27. Remove Element
 * https://leetcode.com/problems/remove-element/
 * 虽然思路简单，但是有很多细节需要注意 比如nums=[1] val = 1, nums[1] val =3等需要注意
 * 提交了5次才通过，对细节细节考虑不周到
 */

public class LeetCode27 {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int right = nums.length - 1;
        for (int left = 0; left <= right; left++) {
            while (left < right && nums[left] != val) {
                left++;
            }
            while (left < right && nums[right] == val) {
                right--;
            }
            if (left == right) {
                if (nums[left] == val) {
                    return left;
                } else {
                    return left + 1;
                }
            } else if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        return nums.length;
    }
}

/**
 * 思路清晰，代码效率更高，可以重点记忆
 */
/*
class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0, n = nums.length -1;
        while( i <= n) {
            if (nums[i] == val) {
                nums[i] = nums[n];
                n--;
            }
            else{
                i++;
            }
        }
        return n + 1;
    }
}*/
