/*
Rune time complexity - O(N) where N is the number of elements in the tree
Space complexity - O(H) for the stack (both in recursion and iterative method)
*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return iterative(root);
        //return checksymmetric(root,root);
    }
    public boolean iterative(TreeNode root)
    {
        Stack<TreeNode> s=new Stack<TreeNode>();
        s.push(root.left);
        s.push(root.right);
        while(!s.isEmpty())
        {
            TreeNode left=s.pop();
            TreeNode right=s.pop();
            if(left==null && right==null)
                continue;
            if(left==null || right==null || left.val!=right.val)
                return false;
            s.push(left.left);
            s.push(right.right);
            s.push(left.right);
            s.push(right.left);
        }
        return true;
    }
    
    
    public boolean checksymmetric(TreeNode t1, TreeNode t2)
    {
        if(t1==null && t2==null)
            return true;
        if(t1==null || t2==null)
            return false;
        return t1.val==t2.val && checksymmetric(t1.left,t2.right) && checksymmetric(t1.right,t2.left);
    }
}
