// Time Complexity : O(N)
// Space Complexity : O(1)
class Solution {
    public boolean check(TreeNode leftRoot, TreeNode rightRoot){
        if(leftRoot==null || rightRoot==null){
            return leftRoot==rightRoot;
        }
        if(leftRoot.val!=rightRoot.val){
            return false;
        }
        return check(leftRoot.left, rightRoot.right) && check(leftRoot.right, rightRoot.left) ;
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
           return true;
        }
        return check(root.left, root.right);
    }
}