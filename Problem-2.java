// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
        Stack<TreeNode> s = new Stack<>();
        
        s.push(root.left);
        s.push(root.right);
        while(!s.isEmpty()) {
            TreeNode right = s.pop();
            TreeNode left = s.pop();
            
            if(right==null && left == null) {
                continue;
            }
            if(right==null || left == null) {
                return false;
            }
            if(right.val != left.val) {
                return false;
            }
            
            s.push(left.left);
            s.push(right.right);
            
            s.push(left.right);
            s.push(right.left);
        }
        return true;
    }
    
}