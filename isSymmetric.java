Time Complexity-O(n)
Space Complexity-O(1)

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return helper(root.left,root.right);
    }
    public boolean helper(TreeNode leftRoot, TreeNode rightRoot)
    {
        if(leftRoot==null && rightRoot==null)
            return true;
        if(leftRoot!=null && rightRoot!=null && leftRoot.val!=rightRoot.val || (leftRoot!=null && rightRoot==null) ||                   (rightRoot!=null && leftRoot==null )) return false;
        return (helper(leftRoot.left,rightRoot.right) && helper(leftRoot.right,rightRoot.left));
        
    }
}
