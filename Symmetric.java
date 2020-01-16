// Time Complexity : O(N)
// Space Complexity : 
// Did this code successfully run on Leetcode : Yes	
// Any problem you faced while coding this : No

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }
    
    private boolean helper(TreeNode root1,TreeNode root2){		// since we know that both the values should be same on left and right, traverse through the tree in both simulatenously
        if(root1 == null && root2 == null) return true;			// base case
        
        if(root1 == null || root2 == null) return false;		// if either one of the root is null, it doesn't obey the symmetric property
        
        return root1.val == root2.val && helper(root1.left, root2.right) && helper(root1.right, root2.left);	// traverse through both sides of the tree
    }
}