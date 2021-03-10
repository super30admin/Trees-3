// Time Complexity :
O(no. of nodes in the tree)
// Space Complexity :
recursive stack would be taking space of O(height of the tree tree) 
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


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
        //If there is no node, then the mirror image would be the same
        if(root == null) return true;
        //Call the recursive function
        //we leave the root Node as it is the same root for both left and right subtree
        else return helper(root.left,root.right);
        
    }
    
    private boolean helper(TreeNode left, TreeNode right){
        //Base conditions
        //1. If the left is null, then right should also be null
        if(left == null || right == null ) return left==right;
        //2. If the left value and the right value are not same, then it will return false
        if(left.val != right.val) return false;
        /*3. we need to recurse through the tree to check if the left node of left subtree
        is equal to the right node of right subtree and vice versa
        */
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
