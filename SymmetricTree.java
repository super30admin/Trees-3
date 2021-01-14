// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



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
        return isMirror(root.left, root.right);
    }

//Recursice approach
    public boolean isMirror(TreeNode n1, TreeNode n2) {

        if(n1 == null && n2 != null) return false;
        if(n2 == null && n1 != null) return false;
        if(n1 == null && n2 == null) return true;

        if(n1.val != n2.val) return false;

        boolean case1 = isMirror(n1.left, n2.right);
        boolean case2 = isMirror(n1.right, n2.left);

        return (case1 && case2);

    }

    
}
