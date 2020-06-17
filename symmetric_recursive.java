// Time Complexity : O(n) we visit every node once only hence O(n) where n=number of unique nodes
// Space Complexity : O(h-1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : It was a relatively straightforward approach I took
// for the recursive problem. Will try the iterative now.


// Your code here along with comments explaining your approach


class Solution {
    public boolean isSymmetric(TreeNode root) {
       
        if(root==null)
            return true;
        
        return helper(root.left,root.right);
    }
    
    // Helper function to traverse each  node and compare left and right nodes
    public boolean helper(TreeNode leftNode, TreeNode rightNode)
    {
        if(leftNode==null && rightNode==null)
            return true;
        if(leftNode==null || rightNode==null)
            return false;
            
        return leftNode.val==rightNode.val && helper(leftNode.left,rightNode.right)  && helper(leftNode.right,rightNode.left);
    }
}