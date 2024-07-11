    // Time Complexity (TC): O(n)
    // Each node in the tree is visited exactly once, where n is the number of nodes in the tree.
    
    // Space Complexity (SC): O(h)
    // The maximum space used by the recursion stack is proportional to the height of the tree, where h is the height of the tree.

class Solution {
    // Main method to check if a binary tree is symmetric
    public boolean isSymmetric(TreeNode root) {
        // Call the helper method to check symmetry using two mirrored trees
        return helper(root, root);
    }
    
    // Helper method to recursively check if two trees are mirrored
    private boolean helper(TreeNode t1, TreeNode t2) {
        // Base case: both nodes are null, they are symmetric
        if (t1 == null && t2 == null) return true;
        
        // If only one node is null, they are not symmetric
        if (t1 == null || t2 == null) return false;
        
        // Check if current nodes' values are equal and their subtrees are symmetric
        return (t1.val == t2.val) && helper(t1.left, t2.right) && helper(t1.right, t2.left);
    }
    

}
