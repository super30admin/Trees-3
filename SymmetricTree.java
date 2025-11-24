// 101. Symmetric Tree
// https://leetcode.com/problems/symmetric-tree/description/

/**
 * Time Complexity: O(n) since we process all nodes
 * Space Complexity: O(h) which is height of the tree
 */

/**
 * Approach: We traverse left and right node parallelly
 * At each step we compare the values.
 * If values mismatch we return false
 */

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right){
        //base case
        if(left == null && right == null){
            return true;
        }

        // if any one out of left/right is missing, tree not symmetrical
        if(left == null || right == null){
            return false;
        }

        if(left.val != right.val){
            return false;
        }

        return helper(left.left, right.right) && helper(left.right, right.left);

    }
}