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
// Time Complexity : O(n) n is total no of nodes in tree
// Space Complexity : O(h) h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class SymmetricTree {
    //boolean flag = true;
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
        //return flag;
    }

    private boolean dfs(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null || left.val!=right.val) return false;

        return dfs(left.left, right.right) && dfs(left.right, right.left);

    }
}

class TreeNode {
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