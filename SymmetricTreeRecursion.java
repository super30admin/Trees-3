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
class Solution {
    
    
    // Time complexity => O(no.of nodes in the tree) as we need to check every node to ensure the tree is symmentric
    
    // Space complexity => 2 * O(n/2) => We will be processing half of the nodes in each pass...
    
    
    public boolean isSymmetric(TreeNode root) {
        
        if(root == null) return true;
        
        return helper(root.left, root.right);
    }
    
    private boolean helper(TreeNode leftNode, TreeNode rightNode) {
        
        if(leftNode == null && rightNode == null) 
            return true;
        
        // The left and right node are not equal
        if(leftNode == null || rightNode == null || leftNode.val != rightNode.val) 
            return false;
        
        //Recursive call
        return helper(leftNode.left, rightNode.right) && helper(leftNode.right, rightNode.left);
        
    }
    
}
