/**
Time Complexity : O(N) , N = number of elements
Space Complexity : O(D), D = depth of the tree
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/
class Solution 
{
    boolean isSymmetric = true;
    
    public boolean isSymmetric(TreeNode root) 
    {
        if(root == null)
        return true;
        
        traverse(root.left, root.right);
        
        return isSymmetric;
    }
    
    
    private void traverse(TreeNode left, TreeNode right)
    {
        if(left == null && right == null)
            return;
        
        if(left != null && right != null)
        {
            if(left.val != right.val)
            {
                isSymmetric = false;
                return;
            }
        }
        else if(left != null || right != null)
        {
            isSymmetric = false;
            return;      
        }
        
        traverse(left.left, right.right);
        traverse(left.right, right.left);
    }
}