/**
 * 128. Longest Consecutive Sequence
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * 放了一天居然自己想到了最优解，其实这种有思路可循，一般要求O(n)只能求助于hashmap
 * 思路：hashmap key为数组的值，value为最长连续值，但是在更新的时候，不需要更新全部
 * 只需要更新连续序列最大处和最小处的key对应的value，直接通过计算可以得出序列最大和最小值，
 * 不需要循环
 */
class LeetCode128 {
    fun longestConsecutive(nums: IntArray): Int {
        val len: Int = nums.size
        if (len <= 1) return len
        var map = mutableMapOf<Int, Int>()
        var max = 0
        for (i in 0 until len) {
            if (map.containsKey(nums[i])) {
                continue
            } else {
                val temp = nums[i]
                val low = map[temp - 1] ?: 0
                val high = map[temp + 1] ?: 0
                val count = low + high + 1
                map[temp - low] = count
                map[temp + high] = count
                map[temp] = count
                max = if (max > count) max else count
            }
        }
        return max
    }
}