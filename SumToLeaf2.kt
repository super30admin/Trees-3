// We need to explore all the paths from root to leaf nodes and check if the sum of values equals targetSum. we use dfs to explore all paths, maintaining the current path and sum.
// When we reach a leaf node, we check if the current sum equals targetSum. If it does, we add the current path to the result list. 
//We backtrack after exploring each path to ensure we can explore other paths correctly.
//Time Complexity: O(N) where N is the number of nodes in the tree. In the worst case, we visit each node once.
//Space Complexity: O(H) where H is the height of the tree. 

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    val result = mutableListOf<List<Int>>()
    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
        helper(root, targetSum, 0, mutableListOf())
        return result

    }
    private fun helper(
        root: TreeNode?,
        targetSum: Int,
        currSum: Int,
        path: MutableList<Int>
    ) {
        if (root == null) return

        val newSum = currSum + root.`val`
        path.add(root.`val`)

        if (root.left == null && root.right == null) {
            if (newSum == targetSum) {
                result.add(path.toList())   // copy the path
            }
        }

        helper(root.left, targetSum, newSum, path)
        helper(root.right, targetSum, newSum, path)

        path.removeAt(path.size - 1)   // backtrack
    }

}