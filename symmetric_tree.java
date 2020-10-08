class Solution {
    public boolean isSymmetric(TreeNode root) {
        
        return helper(root, root);
    }
    
    private boolean helper(TreeNode left, TreeNode right)
    {
        if(left == null && right == null) return true;
        
        if(left == null || right == null) return false;
        
        if(left.val != right.val) return false;
        
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}

// TC- O(N)
//SC- O(1)
/* Here, left and right are the nodes which we need to check are equal or not.
They are not the left and right of the same node. */
