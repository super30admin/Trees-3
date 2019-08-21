// Time Complexity : O(n)
// Space Complexity :
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public boolean isSymmetric(TreeNode root) {
       return isMirror(root,root);
    }

       
// returns true if trees with roots as root1 and root2 are mirror 
   public boolean isMirror(TreeNode node1, TreeNode node2)  
    { 
// if both trees are empty, then they are mirror image 
        if (node1 == null && node2 == null) 
            return true; 
   
     
        if (node1 != null && node2 != null && node1.val == node2.val) 
            return (isMirror(node1.left, node2.right) 
                    && isMirror(node1.right, node2.left)); 
   
       
        return false; 
    } }