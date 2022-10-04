// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Doing a pre-order dfs using 2 pointers.
public class SymmetricTreeSolution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return dfs(root, root);
    }
    
    private boolean dfs(TreeNode p1, TreeNode p2) {
        if(p1 == null && p2 == null) {
            return true;
        }
        if(p1 == null || p2 == null) {
            return false;
        }
        
        if(p1.val != p2.val) {
            return false;
        }
        
        return dfs(p1.left, p2.right) && dfs(p1.right, p2.left);
    }
}
