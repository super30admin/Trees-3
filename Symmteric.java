// Time Complexity : O(N)
// Space Complexity : O(N)
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
class Symmteric {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        
        return check(root.left,root.right);
    }
    
    public boolean check(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null)
            return true;
        
        if((root1!=null && root2==null) || (root2!=null && root1==null))
            return false;
        
        if(root1.val!=root2.val)
            return false;
        
        return (check(root1.left,root2.right) && check(root2.left,root1.right));
    }
}
