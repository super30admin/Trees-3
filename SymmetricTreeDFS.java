// Time complexity: O(N)
// Space complexity: O(H)

// Approach: A tree is symmetric if the left subtree is a mirror reflection of the right subtree. 

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return dfs(root.left, root.right);
    }
    
    private boolean dfs(TreeNode tree1, TreeNode tree2) {
        // base
        if (tree1 == null && tree2 == null) return true;
        if (tree1 == null || tree2 == null || tree1.val != tree2.val) return false;
        
        // logic
        return dfs(tree1.left, tree2.right) && dfs(tree1.right, tree2.left);
    }
}