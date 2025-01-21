// Time Complexity : O(n)
// Space Complexity : O(h): recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I feel level order traversal may add additional complexity but maybe more intutive


// Your code here along with comments explaining your approach
//This is using dfs where we go to the left.left and right.left at the same time and we compare the values.
// we set global variable to false when one of the child is not null or if both are diff for passed left and right
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
//tc:
class SymmtricTree {
    boolean isSymmetric;
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        isSymmetric = true;
        dfs(root.left, root.right);
        return isSymmetric;
    }
    private void dfs(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return;
        }
        if(left == null || right == null){
            isSymmetric = false;
            return;
        }
        if(left.val!=right.val){
            isSymmetric = false;
            return;
        }
        dfs(left.left, right.right);
        dfs(left.right, right.left);
    }
}