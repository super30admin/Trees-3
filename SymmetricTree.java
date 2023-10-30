// Time Complexity : O(N)
// Space Complexity : O(h) h is height of tree.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class SymmetricTree
{
    boolean isSymmetric = true;
    public boolean isSymmetric(TreeNode root) {
        helper(root.left, root.right);
        return isSymmetric;
    }

    public void helper(TreeNode leftRoot, TreeNode rightRoot)
    {
        if(leftRoot == null && rightRoot == null)
            return;
        else if(leftRoot == null
                || rightRoot == null
                || leftRoot.val != rightRoot.val)
        {
            isSymmetric = false;
            return;
        }
        else
        {
            helper(leftRoot.left, rightRoot.right);
            if(isSymmetric)
                helper(leftRoot.right, rightRoot.left);
        }
    }
}
