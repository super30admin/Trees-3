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
class Solution1 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return DFS(root.left, root.right);
    }

    public Boolean DFS(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return true;
        }
        
        if (left == null || right == null){
            return false;
        }
        
        if(left.val != right.val){
            return false;
        }
        
        return DFS(left.left, right.right) && DFS(left.right, right.left);
    }
}