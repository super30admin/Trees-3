class Solution {
    boolean isValid;
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        else
        {
            isValid=true;
            isSymmetric(root.left,  root.right);
        }
        return isValid;
    }
    private void isSymmetric(TreeNode left, TreeNode right)
    {
        if(left==null && right==null) //leaf
            return;
        if(left==null || right==null || left.val != right.val)
        {
            isValid=false;
            return;
        }
        isSymmetric(left.left, right.right);
        isSymmetric(left.right, right.left);
    }
}