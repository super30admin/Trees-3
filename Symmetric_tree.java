// Time Complexity :O(n) n is node of tree
// Space Complexity :O(h) h is height of tree
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public boolean isSymmetric(TreeNode root) {
      return isMirror(root,root);  
    }
    public boolean isMirror(TreeNode root1,TreeNode root2){
        if(root1 == null && root2==null) return true;
        if(root1==null || root2==null ) return false;
        
        return root1.val==root2.val && isMirror(root1.left,root2.right) && isMirror(root1.right,root2.left);
     } 
}
