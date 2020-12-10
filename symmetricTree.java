// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {
    public boolean isSymmetric(TreeNode root) {
        
        return isMirror(root, root);
    }
    
    public boolean isMirror(TreeNode t1, TreeNode t2) {
        
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
        if(t1.val != t2.val) return false;
        
        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
        
    }
}