// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root,root);
        
    }
    public boolean isMirror(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null) return true;
        if(t1==null || t2 == null) return false;
        return( t1.val == t2.val) && isMirror(t1.right, t2.left) && isMirror(t1.left,t2.right);
    }
}