/**
 * 75. Sort Colors
 * https://leetcode.com/problems/sort-colors/
 * 只扫描一次的思路：
 * left是0的边界的指针，right是2的左边界指针
 * cur从头到尾扫描，如果遇到0就和left交换，遇到2就和right交换
 * 因为和left交换后只可能是0或者1，所以不需要在判断一次，即cur不需要--
 * 和right交换后是未扫描过的值，所有cur需要--，再判断一次
 */
public class LeetCode75 {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        int cur = 0, temp;
        for (; cur < right; cur++) {
            if (nums[cur] == 0) {
                temp = nums[cur];
                nums[cur] = nums[left];
                nums[left] = temp;
                left++;
            } else if (nums[cur] == 2) {
                temp = nums[cur];
                nums[cur] = nums[right];
                nums[right] = temp;
                right--;
                cur--;
            }
        }
    }
}
