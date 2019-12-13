/**
 * 136. Single Number
 * https://leetcode.com/problems/single-number/
 * 本题最优算法用亦或实现，
 * 1、相同数字亦或为0
 * 2、其他数字与0亦或不变
 * 参考答案：https://leetcode-cn.com/problems/single-number/solution/zhi-chu-xian-yi-ci-de-shu-zi-by-leetcode/
 * TODO 亦或这种操作真的想不到
 */
class LeetCode136 {
    fun singleNumber(nums: IntArray): Int {
        var result = 0
        nums.forEach { result = result xor it }
        return result
    }
}