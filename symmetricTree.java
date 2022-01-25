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

// T.C - O(N)  S.C - O(H), Height of tree
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null )
            return true;
        
        return helper(root.left, root.right);
    }
    
    private boolean helper(TreeNode left, TreeNode right){
        //base
        if(left == null && right == null) return true;
        if(left == null && right != null) return false;
        if(left !=null && right == null) return false;
        if(left.val != right.val) return false;
        
        //logic
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
