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

//TC: O(n), n: number of nodes
//SC: O(h), h: height of the tree, (log(n))
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return check(root.left, root.right);
    }
    
    private boolean check(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        
        if(left == null || right == null || left.val != right.val) return false;
        
        return check(left.right, right.left) && check(left.left, right.right);
    }
}
