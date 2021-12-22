// Time Complexity :O(N)
// Space Complexity :O(H)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

public class SymmetricTree {
    boolean isValid;
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return false;
        isValid=true;
        helper(root.left,root.right);
        return isValid;
    }
    private void helper(TreeNode left, TreeNode right){
        if(left==null && right==null){
            return ;
        }
        if(left==null || right==null|| left.val!=right.val){
            isValid=false;
            return;
        }
        if(isValid) helper(left.right,right.left);
        if(isValid) helper(left.left,right.right);
    }
}
