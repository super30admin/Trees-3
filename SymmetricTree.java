import javax.swing.tree.TreeNode;

// Time Complexity : O(n), traverse entire tree once
// Space Complexity : O(n) recursive tree of height n
// Did this code successfully run on Leetcode : y
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
        return isMirror(root, root);
    }
    
    private boolean isMirror(TreeNode r1, TreeNode r2){
        if (r1 == null && r2 == null) return true;
        if (r1 == null || r2 == null) return false;
        
        return (isMirror(r1.left, r2.right) && isMirror(r1.right, r2.left) && r1.val == r2.val);
        
    }
}