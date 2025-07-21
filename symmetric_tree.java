// In the solution, we use dfs to iterate over the nodes to check if tree is symmetric or not
// TC: O(n) - as we are visiting each node only once
// SC: O(h) - as we are storing the height of the tree in the recursive call 
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
   // main function to check if tree is symmetric or not
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
    }

    // helper dfs function which does this actual check with recursion
    public boolean dfs(TreeNode left, TreeNode right){
        // if both left and right are null then so far there has been no false and we can return true
        if (left == null && right == null){
            return true;
        }
        // if only one side is null or left value is not equal to right value, return null
        if(left == null || right == null || left.val!=right.val){
            return false;
        }
        // We call dfs recursively 
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}
