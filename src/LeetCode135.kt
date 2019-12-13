/**
 * 135. Candy
 * https://leetcode.com/problems/candy/
 * 这道题有两个难点
 * 1、等于和小于要当做一样来处理，即只需要处理大于的情况
 * 2、对于一个峰值，他的值应该取左右两侧分支取值的较大值，这个问题就转换成了左右各循环一次
 *
 * 想了很久，才想明白，但是一次就做对了
 * TODO 这题有点经典
 */
class LeetCode135 {
    fun candy(ratings: IntArray): Int {
        val length = ratings.size
        if (length == 0) return 0
        var nums = IntArray(length)
        for (i in 1 until length) {
            if (ratings[i] > ratings[i - 1]) {
                nums[i] = nums[i - 1] + 1
            }
        }
        for (i in length - 2 downTo 0) {
            if (ratings[i] > ratings[i + 1] && nums[i + 1] + 1 > nums[i]) {
                nums[i] = nums[i + 1] + 1
            }
        }
        var sum = 0
        nums.forEach {
            sum += it + 1
        }
        return sum
    }
}