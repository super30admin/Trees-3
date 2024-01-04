// Time Complexity : O(n)
// Space Complexity : O(n)
// Method used : DFS

class Solution {
    public boolean isSymmetric(TreeNode root) {
        
        return helper(root, root);
    }

    private boolean helper(TreeNode tree1, TreeNode tree2)
    {
        if(tree1 == null || tree2 == null) return tree1 == tree2;

        else if(tree1.val == tree2.val)
            return helper(tree1.left, tree2.right) && helper(tree1.right, tree2.left);
        
        return false;
    }
}