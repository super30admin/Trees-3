// Time Complexity : O(n)
// Space Complexity : O(h) 
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
        if(root == null){
            return true;
        }
        return recurFn(root.left, root.right);
    }
    
    private boolean recurFn(TreeNode N1, TreeNode N2){
        if(N1 == null && N2 == null){
            return true;
        }
        
        if(N1 == null || N2 == null || N1.val != N2.val){
            return false;
        }
        
        return recurFn(N1.left, N2.right) && recurFn(N1.right, N2.left);
    }
}