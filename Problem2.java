//https://leetcode.com/problems/symmetric-tree/
//Time Complexity : O(N)
//Space Complexity : O(1) ignoring recursion statck
//Did this code successfully run on Leetcode : YES
class Solution {
    Boolean res = true;
    public boolean isSymmetric(TreeNode root) {
        helper(root,root);
        return res;
    }
    
    public void helper(TreeNode l,TreeNode r){
        if(r == null && l == null)
            return;
        if( r == null && l != null || r != null && l == null){
            res = false;
            return;
        }
        
        if( r.val != l.val){
            res = false;
            return;
        }
        
        
        helper(l.left,r.right);
        helper(l.right,r.left);
    }
}