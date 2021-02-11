// Time complexity - O(n)
// space Complexity - O(depth)

// Explanation - Recursively, we check whether the left node of the tree is equal to the right node of the tree.
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return recur(root.left, root.right);
    }
    
    private boolean recur(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null){
            return true;
        }
        
        if(node1 == null || node2 == null || node1.val != node2.val){
            return false;
        }
        
        return recur(node1.left, node2.right) && recur(node1.right, node2.left);
    }
}
