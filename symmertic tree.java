// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


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
    //maintain a true boolean that might change if the tree is not symetric
    boolean isValid;
    public boolean isSymmetric(TreeNode root) {
        isValid = true;
        //if the root is null then it is symeteic
        if(root == null) return isValid;
        //call the helper on the root's left and right
        helper(root.left, root.right);
        //return the isValid which has either true or false
        return isValid;
    }
    
    private void helper(TreeNode left, TreeNode right){
        //base
        //if both are null then it is still valid
        if(left == null && right == null) return;
        //if left equals null or right equals null but the other isn't return false and also check if both aren't the same val
        if(left == null || right == null || left.val != right.val){
            //make isValid equal to false
            isValid = false;
            //return
            return;
        }
        //logic
        //keeping going to left's farthest left and right's farthest right
        helper(left.left, right.right);
        //then go to the farthest left's right and right's left
        helper(left.right, right.left);
    }
}