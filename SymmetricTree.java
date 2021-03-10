/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class SymmetricTree {
    
    // Time Complexity: O(n)    (where n -> no. of nodes in the tree)
    // Space Complexity: O(h)   (where h -> height of the tree)
    public boolean isSymmetric(TreeNode root) {
        // Edge Case Checking
        if(root == null)
            return false;
        return dfs(root.left, root.right);
    }
    
    private boolean dfs(TreeNode left, TreeNode right){
        // Check when we have null nodes -> if both nodes are null then true otherwise false
        if(left == null || right == null)
            return left == right;
        // If the node values are not same then false
        if(left.val != right.val)
            return false;
        
        // Make recursive calls to explore the subtrees
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}