// Time Complexity : O(N) - N is number of nodes in the tree
// Space Complexity : O(N) - As program stack occupies O(N) space due to function calls
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
/*Used a helper function to check whether the tree is symmetric over root or not*/
class Solution {
    public boolean helper(TreeNode root1,TreeNode root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        
        else{
          return (root1.val == root2.val && helper(root1.left,root2.right) && helper(root1.right,root2.left));
        }
        
    }
    public boolean isSymmetric(TreeNode root) {
        return helper(root,root);
    }
}

// Your code here along with comments explaining your approach