// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return helper(root,root);
    }
    private boolean helper(TreeNode leftRoot, TreeNode rightRoot){

        if(leftRoot == null && rightRoot ==null)
            return true;
        if(leftRoot==null || rightRoot ==null){
            return false;
        }
        if(leftRoot.val!=rightRoot.val)
            return false;
        return helper(leftRoot.left, rightRoot.right) && helper(rightRoot.left, leftRoot.right);
    }
}