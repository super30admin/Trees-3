// Time Complexity : O(n) n is number of nodes 
// Space Complexity :O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Symmetric {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root,root);
    }
    
    public boolean isMirror(TreeNode t1, TreeNode t2)
    {
        if(t1==null && t2==null) return true;
        if(t1==null || t2==null) return false;
        return (t1.val==t2.val) && isMirror(t1.left,t2.right) && isMirror(t1.right,t2.left);
    }
}