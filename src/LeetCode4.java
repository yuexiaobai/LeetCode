/**
 * 4. Median of Two Sorted Arrays
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 * 没有做出来，需要重点回顾
 * 讲解博客地址 http://www.cnblogs.com/grandyang/p/4465932.html
 * 九章算法 https://www.jiuzhang.com/solutions/median-of-two-sorted-arrays/
 * 注意点：1、(len1 + len2 + 1) / 2 和 (len1 + len2) / 2 + 1可以解决基偶数的问题，不需要分类讨论
 * 2、中位数可以理解成寻找数组中第k大的数，k是数组和的一半
 * 3、注意边界，以及边界处理的理解。如果数组1无法提供k/2个值，可以由数组2提供，后续数组1还可以提供k/4,k/8等。
 */

// todo 经常复习
public class LeetCode4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return (nums2[nums2.length / 2] + nums2[(nums2.length - 1) / 2]) / 2.0;
        }
        if (nums2 == null || nums2.length == 0) {
            return (nums1[nums1.length / 2] + nums1[(nums1.length - 1) / 2]) / 2.0;
        }
        int len1 = nums1.length;
        int len2 = nums2.length;
        int left = (len1 + len2 + 1) / 2;
        int right = (len1 + len2) / 2 + 1;
        return (getMedian(nums1, 0, nums2, 0, left)
                + getMedian(nums1, 0, nums2, 0, right)) / 2.0;
    }

    //获取数组的第k个值
    public int getMedian(int[] nums1, int start1, int[] nums2, int start2, int k) {
        if (start1 >= nums1.length) return nums2[start2 + k - 1];
        if (start2 >= nums2.length) return nums1[start1 + k - 1];
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);
        int midVal1 = (start1 + k / 2 - 1 < nums1.length) ? nums1[start1 + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (start2 + k / 2 - 1 < nums2.length) ? nums2[start2 + k / 2 - 1] : Integer.MAX_VALUE;
        if (midVal1 < midVal2) {
            return getMedian(nums1, start1 + k / 2, nums2, start2, k - k / 2);
        } else {
            return getMedian(nums1, start1, nums2, start2 + k / 2, k - k / 2);
        }
    }
}
