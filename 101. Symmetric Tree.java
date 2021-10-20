// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//we start from comaring left and right node with respect to given conditions and if both ends comparison gives true then we return true else
//we return false

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
        if(root==null){
            return true;
        }
        
        return helper(root.left, root.right);
    }
    public boolean helper(TreeNode N1, TreeNode N2){
        if(N1==null && N2==null){
            return true;
        }
        if(N1==null || N2==null ||N1.val!=N2.val){
            return false;
        }
        return helper(N1.left, N2.right) && helper(N1.right, N2.left);
        
        
    }
    
}