// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSame(root, root);
    }
    
    private boolean isSame(TreeNode left, TreeNode right){
        
        if(left==null && right==null){
            return true;
        }
        if(left==null || right==null){
            return false;
        }
        return (left.val==right.val) && isSame(left.left, right.right) && isSame(left.right, right.left);
    }
}