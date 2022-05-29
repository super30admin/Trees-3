// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//traversed through the tree both left and right sides and if one of them is null or their values are not same then make the
global variable inValid as false and return;
else move to the right of node1 and left of the node2


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
    boolean isValid = true;
    public boolean isSymmetric(TreeNode root) {
        dfs(root,root);
        return isValid;
    }
    private void dfs(TreeNode node1,TreeNode node2){
        //base
        if(node1==null && node2==null) return;
        
        //logic
        if(node1==null || node2==null || node1.val!=node2.val){
            isValid = false;
            return;
        }
        dfs(node1.left,node2.right);
        dfs(node1.right,node2.left);
       
    }
}