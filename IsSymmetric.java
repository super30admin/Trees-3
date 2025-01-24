// Time complexity : O(n)
// Space Complexity : O(h)


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
    // Boolean isSymmetric;
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        //isSymmetric  = true;
        return dfs(root.left, root.right);
        //return isSymmetric;
    }
    public boolean dfs(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        if(left.val != right.val){
            // isSymmetric = false;
            return false;
        }
        return (dfs(left.left, right.right) && dfs(left.right, right.left));
    }
}