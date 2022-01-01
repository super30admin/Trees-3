// Time Complexity : O(height of tree)
// Space Complexity : O(height of tree)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
/**
 * We traverse through left subtree and right subtree from start. and check if left.val and right.val is same or not
 * We continue this checks till end and during each recursive call we send left.left, right.right and left.right, right.left
 * We check for follwing conditions for each level, 
 * 1. if one node is null and other is not then we return false 2. If node value is not same we return false
 * 3. if both nodes are null, we return true
 * If in any call, we did not get false result then we return true as in tree is symmetric
*/

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
    
    private boolean helper(TreeNode node1, TreeNode node2){
        //base case
        if(node1 == null && node2 == null)return true;
        if(node1 == null || node2 == null)return false;
        
        //logic
        if(node1.val != node2.val)return false;
        if(helper(node1.left, node2.right) == false)return false; 
        if(helper(node1.right, node2.left) == false)return false;
        
        return true;
    }
}