// Time Complexity : O(n), where n is the number of nodes 
// Space Complexity : O(h), where h is the height of the tree 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -

// Your code here along with comments explaining your approach:
// Defined TreeNode class for the structure of each node in the binary tree
// inOrder recursively checks if left and right subtrees are mirror images of each other
// isSymmetric simply initiates the mirror comparison starting from the root's left and right children

public class symmetricTree {
    public class TreeNode 
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public boolean inOrder(TreeNode left , TreeNode right)
    { 
        if((left != null && right == null) || (right != null && left == null))
        {
            return false;
        }
        else if(left==null && right==null)
        {
            return true;
        }
        else if(left.val != right.val)
        {
            return false;
        }
        else
        {
            return inOrder(left.left,right.right)&&inOrder(left.right,right.left);
        }
    }
    public boolean isSymmetric(TreeNode root) 
    {
        return inOrder(root.left , root.right);
    }
}