// Time Complexity : O(N) where N is the number of nodes
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Use dfs and recurse, checking if nodes are present and corresponding nodes are equal.
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return helper(root,root);
    }

    private boolean helper(TreeNode t1, TreeNode t2){
        if(t1==null && t2==null) return true;
        if(t1==null || t2==null) return false;
        if(t1.val!=t2.val) return false;
        return helper(t1.left,t2.right) && helper(t1.right,t2.left);
    }
}

