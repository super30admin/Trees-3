// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity : O(n) since we are through all nodes of the tree.
//Space Complexity: O(1) since we are not taking any extra space 
class Solution {
    public boolean isSymmetric(TreeNode root)
    {
        if(root == null) return false;
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right)
    {
        //base condition
        if(left == null && right == null) return true;

        //If any of the left or right nodes is null, that means the other part is not null and so not symmetric
        if(left == null || right == null) return false;
        
        //logic
        if(left.val != right.val) return false;
        
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}