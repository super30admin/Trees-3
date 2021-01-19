// Time Complexity :O(n) n is number of nodes
// Space Complexity : O(h) h is height of the tree worst case height is n 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 


// Your code here along with comments explaining your approach
class Solution {
    boolean isSymmetric;
    public boolean isSymmetric(TreeNode root) {
        
        if(root == null) return true;
        isSymmetric = true;
        helper(root.left,root.right);
        return isSymmetric;
    }
    
    private void helper(TreeNode left, TreeNode right)
    {
        if(left == null && right == null ) return;
        
        if(left == null || right==null || left.val!=right.val)
        {
            isSymmetric = false;
            return ;
        }
        
        helper(left.left,right.right);
        helper(left.right,right.left);
        
    }
}