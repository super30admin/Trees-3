// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach

class SymmetricTreeSolution {
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
  public boolean isSymmetric(TreeNode root) {
    if(root==null)
        return true;
    return helper(root.left, root.right);
  }
  private boolean helper(TreeNode left, TreeNode right) {
    if(left==null && right==null)
        return true;
    if(left == null || right == null || left.val!=right.val)
        return false;
    return (helper(left.left, right.right) && helper(left.right, right.left));
  }
}