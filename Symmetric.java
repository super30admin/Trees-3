// Time Complexity : O(N) where N number of nodes
// Space Complexity : O(H) where H is height of the tree
// Did this code successfully run on Leetcode : Yes	
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

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
    public boolean isSymmetric(TreeNode root) {
        //base
        if(root == null){
            return true;
        }
        return helper(root.left, root.right);
    }
    
    public boolean helper(TreeNode left, TreeNode right){
	//Logic
        if(left == null || right == null){
            return left == right;
        } 
        if(left.val != right.val){
            return false;
        } 
        
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}