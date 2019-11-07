import kotlin.math.max

/**
 * 124. 二叉树中的最大路径和
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 * 此题有几个难点：
 * 1、int类型会溢出  可以通过0来避免，参考了优秀算法
 * 2、思路比较绕
 * 自己想出了解决方法，但是未想到int溢出
 */
class LeetCode124 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    var pathSum = Int.MIN_VALUE.toLong()
    fun maxPathSum(root: TreeNode?): Int {
        getMaxSum(root)
        return pathSum.toInt()
    }

    private fun getMaxSum(root: TreeNode?): Long {
        if (root == null) {
            return Int.MIN_VALUE.toLong()
        }
        val leftSum = getMaxSum(root.left)
        val rightSum = getMaxSum(root.right)
        pathSum = max(leftSum, pathSum)
        pathSum = max(rightSum, pathSum)
        val a = root.`val`.toLong()
        val b = a + leftSum
        val c = a + rightSum
        val d = a + leftSum + rightSum
        val result = max(a, max(b, c))
        pathSum = max(pathSum, max(d, result))
        return result
    }
}

// 优秀算法
/*private fun Int.nonneg() = if (this < 0) 0 else this

class Solution {
    private var result = Int.MIN_VALUE

    private fun maxBranchSum(n: TreeNode?): Int {
        if (n == null)
            return 0

        val l = maxBranchSum(n.left).nonneg()
        val r = maxBranchSum(n.right).nonneg()
        result = maxOf(result, n.`val` + l + r)
        val m = maxOf(l, r)
        return n.`val` + m
    }

    fun maxPathSum(root: TreeNode?): Int {
        maxBranchSum(root)
        return result
    }
}*/

