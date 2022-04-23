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

Approach 1 with less optimization
class Solution {

    // Time Complexity : 0(n) where n is the nodes in the tree
// Space Complexity : 0(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: I declared a global variable status to keep a track of the
    //condition of symmetry. Then I pass the left subtree and right subtree individually to my recursive function. Then I check
    //for conditions for it to be symmetric along with a base condition. If the right and left are null, it returns true.
    //If right and left are null and if right value is not equal to left value, then it changes the status. Then if the status
    //remains true, then I recursively call the right and left subtree and visit each node to check all the above conditions.

    boolean status;
    public boolean isSymmetric(TreeNode root) {
        status = true;
        helper(root.left, root.right);
        return status;
    }
    public void helper(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return;
        }
        if(left == null || right == null || left.val != right.val){
            status = false;
            return;
        }
        if (status == true){
            helper(left.left, right.right);
            helper(left.right, right.left);
        }
    }
}

//Approach 2 with more optimization
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
        return helper(root.left, root.right);
    }
    public boolean helper(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null || left.val != right.val){
            return false;
        }
        boolean case1 = helper(left.left, right.right);
        boolean case2 = helper(left.right, right.left);
        return case1 && case2;
    }
}