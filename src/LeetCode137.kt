/**
 * 137. Single Number II
 * https://leetcode.com/problems/single-number-ii/
 * 参考题解：https://leetcode-cn.com/problems/single-number-ii/solution/single-number-ii-mo-ni-san-jin-zhi-fa-by-jin407891/
 * TODO：太难了，反正想不出来,136和137都非常经典
 */
class LeetCode137 {
    fun singleNumber(nums: IntArray): Int {
        var ones = 0
        var twos = 0
        nums.forEach { num ->
            ones = ones xor num and twos.inv()
            twos = twos xor num and ones.inv()
        }
        return ones
    }
}