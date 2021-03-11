// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// We are using recursive approach here. We keep going from the the root to the leaf node and keep returning true whenever a node left child is same
// as the right child of the right node at the same level. Whenever this is not true or we see a null we stop the recursion and return a false.
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
      
      if(root==null)
        return true;
      
      return isValid(root.left,root.right);
        
    }
  
  public boolean isValid(TreeNode left,TreeNode right)
  {
    
    if(left == null && right == null)
    {
      return true;
    }
  
    if(left == null || right == null || left.val != right.val)
    {
      return false;
    }
  
    return isValid(left.left , right.right) && isValid(left.right , right.left);
  }
}