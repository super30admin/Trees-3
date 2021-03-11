// Time Complexity :O(n)
// Space Complexity :O(h) - height of the tree
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
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
        if(root == null) return true;
        return recurr(root.left, root.right);
    }
    
    private boolean recurr(TreeNode N1, TreeNode N2){
        if(N1 == null && N2 == null) {
            return true;
        }
        if(N1 == null || N2 == null || N1.val != N2.val){
            return false;
        }
        return recurr(N1.left, N2.right) && recurr(N1.right, N2.left);
    }
}