//T.C : O (N)
//S.C: O(h)
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
// T.C O(N);
// S.C O (h);
class Solution {
    boolean isValid;
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
    
      return dfs(root.left,root.right);
    
        
    }
    private  boolean dfs(TreeNode left, TreeNode right){
        if(left==null && right==null)return true;
        if(left==null || right==null || left.val!=right.val){
           
            return false;
        }
      return   dfs(left.left,right.right)&&dfs(right.left,left.right);
        
  
    }
}
