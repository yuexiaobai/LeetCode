/**
 * 134. Gas Station
 * https://leetcode.com/problems/gas-station/
 * 虽然想了很久但是没有想到最优算法，主要没有转过来的点是
 * 只要所有差值的和>=0,就肯定有可以到达，不用验证
 * 我为了验证这个问题，把数组长度扩大了2倍
 * TODO 1、复习最优算法，记住 只要所有差值的和>=0,就肯定有可以到达，不用验证！！！
 */
class LeetCode134 {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        val length = gas.size
        var sum = 0
        var start = -1
        val rest = IntArray(2 * length) {
            gas[it % length] - cost[it % length]
        }
        for (i in 0 until 2 * length) {
            if (sum == 0) start = i
            sum += rest[i]
            if (sum < 0) {
                sum = 0
            } else if (i - start == length - 1) {
                return start
            }
        }
        return -1
    }
}

/**
 * 最优算法
 */
/*class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int total_tank = 0;
        int curr_tank = 0;
        int starting_station = 0;
        for (int i = 0; i < n; ++i) {
            total_tank += gas[i] - cost[i];
            curr_tank += gas[i] - cost[i];
            // If one couldn't get here,
            if (curr_tank < 0) {
                // Pick up the next station as the starting one.
                starting_station = i + 1;
                // Start with an empty tank.
                curr_tank = 0;
            }
        }
        return total_tank >= 0 ? starting_station : -1;
    }
}*/
