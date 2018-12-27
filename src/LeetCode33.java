/**
 * 33. Search in Rotated Sorted Array
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * 思路比较清晰,边界判断不清，判断边界是否有=需要注意
 * 如果在加些条件判断，可以更快，参考最优方法判断逻辑
 */
public class LeetCode33 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1;
        return getMid(nums, start, end, target);
    }

    public int getMid(int[] nums, int start, int end, int target) {
        if ((start == end && nums[start] != target) || start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (nums[mid] == target)
            return mid;
        if (nums[mid] >= nums[start] && nums[mid] >= nums[end]) {
            if (nums[mid] > target) {
                return getMid(nums, start, mid - 1, target) + getMid(nums, mid + 1, end, target) + 1;
            } else {
                return getMid(nums, mid + 1, end, target);
            }
        } else if (nums[mid] <= nums[end]) {
            if (nums[mid] > target) {
                return getMid(nums, start, mid - 1, target);
            } else {
                return getMid(nums, start, mid - 1, target) + getMid(nums, mid + 1, end, target) + 1;
            }
        }
        return -1;
    }
}

// 最优方法，思路清晰
/*
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            int mid = (right + left)/2;
            if (nums[mid] == target) return mid;

            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
*/
