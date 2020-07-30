// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode :  yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach



class Solution {
    
    public boolean isSymmetric(TreeNode root) {   
   
    
         if(root ==  null)
             return true;
        
        return helper(root.left,root.right);
    
    }
    
    private boolean helper(TreeNode root1 ,TreeNode root2){
        
        if(root1 == null  && root2 == null)
            return true;
       if(root1 == null || root2 == null)
           return false;
       
        
        return root1.val == root2.val && helper(root1.left ,root2.right) && helper(root1.right,root2.left);
        
        
    }
    
}