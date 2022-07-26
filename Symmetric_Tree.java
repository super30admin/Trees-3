// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approachclass Solution {
    boolean isvalid= true;
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
        {
            return isvalid;
        }
        helper(root.left,root.right);

        return isvalid;
    }
    private void helper(TreeNode left, TreeNode right)
    {
        if(left == null && right == null)
        {
            return;
        }
        if(left == null || right == null || left.val!= right.val)
        {
            isvalid=false;
            return;
        }
        helper(left.left,right.right);
        helper(left.right,right.left);
    }
}