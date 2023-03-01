// Time Complexity : O(n) where n is number of nodes in tree
// Space Complexity : O(h) where h is the height of tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/* We use recursion. We pass left and right child of root to dfs func. Then we recursively call the left.left, right.right
   and left.right and right.left on tree. We compare the values to find any breach. If values are equal throughout the tree
   we return true, else if we find a breach we return false.
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
    boolean isValid;
    public boolean isSymmetric(TreeNode root) {
        if(root == null)return true;

        isValid = true;

        dfs(root.left, root.right);

        return isValid;
    }

    private void dfs(TreeNode left, TreeNode right){

        if(left == null && right == null)return;
        if(left == null || right == null || left.val != right.val){
            isValid = false;
            return;
        }

        dfs(left.left, right.right);
        dfs(left.right, right.left);
    }
}