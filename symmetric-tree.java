// Time - O(N)
// Space - O(N)
class Solution {
    public boolean isSymmetric(TreeNode root) {
        
        if(root == null)
            return true;
        return helper(root.left, root.right);
    }
    
    private boolean helper(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if((left == null || right == null) || left.val != right.val) return false;
        
        return helper(left.left, right.right) && helper(left.right, right.left);
        
    }
}
