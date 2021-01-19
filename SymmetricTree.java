/**
Leetcode Problem 101: Symmetric Tree
https://leetcode.com/problems/symmetric-tree/

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:


Collabedit: http://collabedit.com/bwq4u

Time Complexity : O(N)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

**/
class Solution 
{

    boolean isSymmetricTree = true;
    
    public boolean isSymmetric(TreeNode root) 
    {
        if(root == null) return true;
        
        isSymmetricRecursive(root.left, root.right);
        
        return isSymmetricTree;
    }
    
    
    private void isSymmetricIterative(TreeNode root)
    {
        if(root == null || (root.left == null && root.right == null)) return;
        
        Stack<TreeNode> stack = new Stack<>();
        
        stack.push(root.left);
        stack.push(root.right);
        
        while( !stack.isEmpty() )
        {
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();
            
            if( left == null && right == null) continue;
            
            if( (left == null && right != null ) || (right == null && left != null) || (left.val != right.val))
            {
                this.isSymmetricTree = false;
                return;
            }
            
            stack.push( right.right);
            stack.push( left.left);
            stack.push( right.left);
            stack.push( left.right);
        
        }
    }
    
    private void isSymmetricRecursive(TreeNode left, TreeNode right)
    {
        if(left == null && right == null) return;

        if( (left == null && right!=null) || (right == null && left!= null ) || left.val != right.val)
        {
            this.isSymmetricTree = false;
            return;
        }
        
        isSymmetricRecursive(right.right, left.left);
        isSymmetricRecursive(right.left, left.right);
    
    
    }
    
    
    
}

