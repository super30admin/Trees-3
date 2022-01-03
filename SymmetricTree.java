// Time Complexity :O(N)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

//check left of left node with right of right node
//check right of left node with left of right node
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return dfs(root.left,root.right);
        // return isValid;
    }

    private boolean dfs(TreeNode left , TreeNode right){
        //base
        if(left == null && right == null){
            return true;
        }
        if(left == null || right ==null || left.val != right.val){
            return false;
        }
        //logic
        return (dfs(left.left,right.right) && dfs(left.right,right.left));
    }
}