// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public boolean isSymmetric(TreeNode root) {
        
       return  root==null || findSym(root.left, root.right);
        
    }
    public boolean findSym(TreeNode right, TreeNode left){
 
        if(left==null || right==null)
        return left==right;
        if(left.val!=right.val)
            return false;
    return findSym(left.left, right.right) && findSym(left.right, right.left);
}
            
        }

    
