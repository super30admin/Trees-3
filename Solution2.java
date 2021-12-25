// Time Complexity :O(n) touching all the nodes
// Space Complexity :O(h) maximum elements in the recursive stack can be h
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
 
 
class Solution {

    // Definition for a binary tree node.
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
        if(root==null) return true;
        
        return dfs(root.left,root.right);
    }
    private boolean dfs(TreeNode left, TreeNode right){
    
    //base case
    if(left == null && right == null){
        return true;
    }
    //logic
    //if either of them is null and value does not match
    if(left== null || right==null || left.val!=right.val)
        return false;
    
    return dfs(left.left,right.right) && dfs(left.right,right.left);
 }  
    
}
