// Time Complexity : O(n)
// Space Complexity : O(1)
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
    public boolean isSymmetric(TreeNode root) {
        
        if(root == null)
            return true;
        
        return helper(root.left, root.right);
    }
    
    public boolean helper(TreeNode t1, TreeNode t2){
        //if both the nodes are null then its symmetric
        if(t1 == null && t2 == null)
            return true;
        //if only 1 node is null then it is not symmetric
        else if(t1 == null || t2 == null){
            return false;
        }
        else{
            //if the value if not equal then we don't need to explore further
            return (t1.val == t2.val) && helper(t1.left, t2.right) && helper(t1.right, t2.left);
        }
    }
}