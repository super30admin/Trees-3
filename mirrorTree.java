// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public boolean isSymmetric(TreeNode root) {
        
        if(root==null){
            return true;
        }
        return recurr(root.left,root.right);
        
    }
    private boolean recurr(TreeNode p1, TreeNode p2){
        
        if(p1==null && p2==null){
            return true;
        }
        
        if(p1==null || p2==null || p1.val!=p2.val){
            return false;
        }
        
        return recurr(p1.left, p2.right) && recurr(p1.right, p2.left);
    }
}