/**
 * 55. Jump Game
 * https://leetcode.com/problems/jump-game/
 * 完美完成，貌似这种算法也碰到了几次了
 */
public class LeetCode55 {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (len == 0 || len == 1) {
            return true;
        }
        int maxpos = nums[0] <= len - 1 ? nums[0] : len - 1;
        if (maxpos == len - 1) {
            return true;
        }
        int pos = 1;
        while (pos <= maxpos) {
            int right = pos + nums[pos];
            if (right > maxpos) {
                maxpos = right <= len - 1 ? right : len - 1;
            }
            if (maxpos == len - 1) {
                return true;
            }
            pos++;
        }
        return false;

    }
}
