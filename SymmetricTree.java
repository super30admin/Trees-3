// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        
        return dfs(root.left, root.right);
    }
    
    private boolean dfs(TreeNode left, TreeNode right) {
        
        if(left == null && right == null) return true;
        
        if(left == null || right == null || left.val != right.val) {
            return false;
        }
        
        return dfs(left.left, right.right) && 
        dfs(left.right, right.left);
    }
}
