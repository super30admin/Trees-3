//In this problem, we check if each side of the root node are mirror images of each other or not. 
//Time Complexity: O(N) where N is the number of nodes in the tree.
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
    fun isSymmetric(root: TreeNode?): Boolean {
        return root == null || inorder(root.left, root.right)
    }

    fun inorder(t1: TreeNode?, t2: TreeNode?) : Boolean {
        if (t1 == null || t2 == null) {
            return t1 == t2
        }

        if(t1.`val` != t2.`val`) return false 

        return inorder(t1.right, t2.left) && inorder(t1.left, t2.right)
    }
}