// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root==null?true:helper(root.left,root.right);
    }
    
    private boolean helper(TreeNode leftNode,TreeNode rightNode){
        if(leftNode == null && rightNode == null)return true;
        if(leftNode == null || rightNode == null)return false;
        if(leftNode.val != rightNode.val)return false;
        return helper(leftNode.left,rightNode.right) && helper(leftNode.right,rightNode.left);
    }
}