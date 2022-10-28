class Solution {
    public boolean isSymmetric(TreeNode root) {
        return  isSymmetric(root.left, root.right);
    }
    public boolean isSymmetric(TreeNode a, TreeNode i){
        if(a == null && i == null){
            return true;
        }
        if ( a == null || i == null || a.val!=i.val){
            return false;
        }
        return isSymmetric(a.left, i.right) && isSymmetric(a.right, i.left);
    }
    
}
//tc=O(n)
//sc=O(n)
