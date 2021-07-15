// Time complexity: O(N), where N is the number of nodes in the tree. 
// Space complexity: O(d), where d is the maximum depth of the tree.

class Solution {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }


  public boolean helper(TreeNode node1, TreeNode node2) {
        // base case 1 - if both nodes are null
        if (node1 == null && node2 == null)
            return true;
        // base case 1 - if only one node is null 
        if (node1 == null || node2 == null)
            return false;
        // check if the current values are same and left subtree is symmetric to right subtree and vice versa.
        return node1.val == node2.val && helper(node1.left, node2.right) && helper(node1.right, node2.left); 
    }
    public boolean isSymmetric(TreeNode root) {
        return helper(root, root); 
    }
}