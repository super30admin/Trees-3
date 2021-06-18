class Solution {
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }
    public boolean helper(TreeNode r1, TreeNode r2){
        // various conditions
        if(r1 == null && r2 == null)
            return true;
        if(r1 == null || r2 == null)
            return false;
        if(r1.val != r2.val)
            return false;
       return helper(r1.left, r2.right) && helper(r1.right, r2.left);
    }
}
