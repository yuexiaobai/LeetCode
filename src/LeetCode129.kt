/**
 * 129. Sum Root to Leaf Numbers
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 * 题目中等，但是也比较容易犯错，主要是需要在叶子节点时再计算和
 */
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class LeetCode129 {
    var sum: Int = 0
    fun sumNumbers(root: TreeNode?): Int {
        if (root == null) return 0
        getNumbers(root, root.`val`)
        return sum
    }

    fun getNumbers(root: TreeNode?, value: Int) {
        root!!.left?.let {
            getNumbers(root.left, value * 10 + it.`val`)
        }
        root.right?.let {
            getNumbers(root.right, value * 10 + it.`val`)
        }
        if (root.left == null && root.right == null) {
            sum += value
        }
    }
}