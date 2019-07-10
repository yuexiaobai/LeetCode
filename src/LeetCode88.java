/**
 * 88. Merge Sorted Array
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class LeetCode88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n;
        for (int i = len - 1; i >= 0; i--) {
            int val1 = Integer.MIN_VALUE, val2 = Integer.MIN_VALUE;
            if (m - 1 >= 0) {
                val1 = nums1[m - 1];
            }
            if (n - 1 >= 0) {
                val2 = nums2[n - 1];
            }
            if (val1 >= val2) {
                nums1[i] = val1;
                m--;
            } else {
                nums1[i] = val2;
                n--;
            }
        }
    }
}
