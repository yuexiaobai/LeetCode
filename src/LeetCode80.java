/**
 * 80. Remove Duplicates from Sorted Array II
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 * 独立完成，比较简单，思路如下：
 * 1、首先计算出来需要替换的第一个位置，即replace位置
 * 2、在replace>0情况下，即真正有超过2个的数字时，让后面count<=2的数字覆盖当前位置的数字，并且replace++
 */
public class LeetCode80 {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length < 2) {
            return nums.length;
        }
        int count = 1, replace = 0, prenum = nums[0];
        boolean hasreplace = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prenum) {
                count += 1;
                if (count > 2 && replace == 0) {
                    hasreplace = true;
                    replace = i;
                }

                if (count <= 2 && replace != 0) {
                    nums[replace] = nums[i];
                    replace++;
                }
            } else {
                prenum = nums[i];
                count = 1;
                if (replace != 0) {
                    nums[replace] = nums[i];
                    replace++;
                }
            }

        }
        return hasreplace ? replace : nums.length;
    }
}
