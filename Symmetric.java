//Time complexity: O(n)
//Space complexity: O(height of tree)
//Executed on leetcode
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
        if(root==null) return true;			//To be symmetric, left value of left subtree should be equal to right value of right subtree and right of left should be equal to left of right
        
        return isMirror(root.left, root.right);
        
    }
    
    private boolean isMirror(TreeNode T1, TreeNode T2)
    {
        if(T1==null && T2==null)
            return true;									//If both the sides are null just returning true.
        if(T1==null || T2==null || T1.val != T2.val)		//if left subtree lookup value is not equal to right subtree lookup value returning false
            return false;
        
        return isMirror(T1.left, T2.right) && isMirror(T1.right , T2.left);
    }
}