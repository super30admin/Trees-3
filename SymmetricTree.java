// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Create a function with two TreeNode parameters
//If root is null return true, call the function passing left and right of tree
//Check for null and values not equals
//Call recursivelt testing for the mirror of children.
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
        if(root == null)
            return true;
        return isSymmetric(root.left, root.right);
    }
    private boolean isSymmetric(TreeNode a, TreeNode b){
        if(a == null && b == null)
            return true;
        if(a == null || b == null || a.val != b.val)
            return false;
        return isSymmetric(a.left, b.right) && isSymmetric(a.right, b.left);
    }
}