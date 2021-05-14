// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

public class symmetricTree {

    boolean isValid;
    public boolean isSymmetric(TreeNode root) {
        isValid=true;
        
        if(root==null)
            return true;
        isValid=true;
        
        helper(root.left, root.right);
        
        return isValid;
    }
    
    private void helper(TreeNode left, TreeNode right){
        if(left==null && right==null)
            return;
        
        if(left==null || right==null || left.val!=right.val){
            isValid=false;
            return;
        }
        
        helper(left.left, right.right);
        helper(left.right, right.left);
        
    }
    
}
