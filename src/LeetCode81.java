/**
 * 81. Search in Rotated Sorted Array II
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 * 并没有做出来，这个题主要是判断那边是有序的，
 * 思路是先判断那边是有序的，如果不在有序的那边，那就去无序的那边，无序那边不做其他判断。
 */
public class LeetCode81 {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int n = nums.length, left = 0, right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] < nums[right]) {
                if (nums[mid] < target && nums[right] >= target) left = mid + 1;
                else right = mid - 1;
            } else if (nums[mid] > nums[right]) {
                if (nums[left] <= target && nums[mid] > target) right = mid - 1;
                else left = mid + 1;
            } else --right;
        }
        return false;
    }

}
