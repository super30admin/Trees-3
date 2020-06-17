// Time Complexity : O(n) where n is the nodes in the tree
// Space Complexity :O(h) h is the height of the recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left,root.right);
        
    }
    
    private boolean helper (TreeNode right, TreeNode left ){
        //base case
        if(right == null && left == null) return true;
        if(right ==null || left == null || right.val!=left.val) return false;
        
        //logic
        return helper(right.right, left.left) && helper(right.left,left.right);
    }
}