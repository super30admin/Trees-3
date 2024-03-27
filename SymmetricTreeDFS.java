
// Time Complexity : O(n) : All nodes of Tree
// Space Complexity : O(h) : Recursive stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*
 * DFS with return value based recursion
 * Keep adding root's left and root's right
 * If either of found / null or both left and right values are not same then it is not symmetric.
 * 
 * This problem is also being referred as Mirror Image of given Tree
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
    // private boolean flag; //by default false
    public boolean isSymmetric(TreeNode root) {

        if(root == null) 
            return true;

        //procced when root is not null that means tree is there.
        // this.flag = true;
        return dfs(root.left, root.right); // boolean based recursion
        // return flag;
    }
    //boolean dfs
    private boolean dfs(TreeNode left, TreeNode right){
        //base
        if(left == null && right == null) return true;

        //breach
        if(left == null || right == null || left.val != right.val) {
            // flag = false;
            return false;
        }
        
        //logic
       if(dfs(left.left, right.right) == false) return false;
       return dfs(left.right, right.left);

       //shorten code for if conditions to avoid calls

    }
}