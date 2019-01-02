/**
 * 34. Find First and Last Position of Element in Sorted Array
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 优秀方法与此方法有点不同，分别递归寻找左右结果
 */
public class LeetCode34 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums.length == 0) {
            return result;
        }
        int pos = getTargetByQuicSort(nums, 0, nums.length -1, target);
        if (pos == -1) {
            return result;
        }
        for (int i = pos; i < nums.length; i++) {
            if (nums[i] == target) {
                result[1] = i;
            } else {
                break;
            }
        }

        for (int i = pos; i >= 0; i--) {
            if (nums[i] == target) {
                result[0] = i;
            } else {
                break;
            }
        }
        return result;
    }

    public int getTargetByQuicSort(int[] nums, int start, int end, int target) {
        if (start > end) {
            return -1;
        } else if (start == end) {
            if (nums[start] == target) {
                return start;
            } else {
                return -1;
            }
        }
        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] >= target) {
            return getTargetByQuicSort(nums, start, mid - 1, target);
        } else {
            return getTargetByQuicSort(nums, mid + 1, end, target);
        }

    }
}

// 优秀方法
/*class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ret = new int[] {-1, -1};
        int size = nums.length;
        if(size == 0 || target < nums[0] || target > nums[size - 1])
            return ret;

        ret[0] = findFirst(nums, 0, size - 1, target);
        ret[1] = findLast(nums, 0, size - 1, target);

        return ret;
    }

    int findFirst(final int[] nums, int l, int r, final int target) {
        if(l > r) return -1;
        else if(l == r) return target == nums[l] ? l : -1;

        int mid = (l + r) / 2;
        if(nums[mid] == target) {
            if(mid == l)
                return l;
            else {
                if(nums[mid] != nums[mid - 1]) {
                    return mid;
                } else {
                    return findFirst(nums, l, mid - 1, target);
                }
            }

        } else if(nums[mid] < target) {
            return findFirst(nums, mid + 1, r, target);
        } else {
            return findFirst(nums, l, mid - 1, target);
        }
    }

    int findLast(final int[] nums, int l, int r, final int target) {
        if(l > r) return -1;
        else if(l == r) return target == nums[l] ? l : -1;

        int mid = (l + r) / 2;
        if(nums[mid] == target) {
            if(mid == r)
                return r;
            else {
                if(nums[mid] != nums[mid + 1]) {
                    return mid;
                } else {
                    return findLast(nums, mid + 1, r, target);
                }
            }

        } else if(nums[mid] < target) {
            return findLast(nums, mid + 1, r, target);
        } else {
            return findLast(nums, l, mid - 1, target);
        }
    }
}*/
