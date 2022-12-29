// Time Complexity : O(n)
// Space Complexity : O(h) - h(height of tree)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class SymmetricTree {

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
 
    boolean flag;
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        flag = true;
        dfs(root.left, root.right);
        return flag;
    }

    private void dfs(TreeNode left, TreeNode right ){
        //base
        if (left == null && right == null) return;
        //logic
        if (left == null || right == null || left.val!=right.val){
            flag = false;
            return;
        }
        dfs(left.left, right.right);
        dfs(left.right, right.left);
    }

    
}
