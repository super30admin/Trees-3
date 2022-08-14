// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }
    
    public boolean helper(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        
        boolean l=helper(left.right, right.left);
        boolean r=helper(left.left, right.right); 
        return l && r && left.val==right.val; 
    }
}