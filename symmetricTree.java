// Time Complexity : O(n) -> since we are traversing all nodes
// Space Complexity : O(h) -> since we are going down all the level i.e. upto height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    boolean res;
    public boolean isSymmetric(TreeNode root) {
        
        //base case
        if(root == null){
            return true;
        }
        
        //initializing result variable to true
        res = true;

        //triggering dfs call
        dfs(root.left, root.right);

        return res;

    }
    private void dfs(TreeNode left, TreeNode right){
        //basecase
        if(left == null && right == null){
            return;
        }
        if(left == null || right == null){
            res = false;
            return;
        }
        if(left.val != right.val){
            res = false;
            return;
        }

        dfs(left.left, right.right);
        dfs(left.right, right.left);
    }
}