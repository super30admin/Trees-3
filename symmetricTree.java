/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

// Time Complexity : O(H), H is the height of the tree
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach
/*
 * we create a boolean flag setting it to true intiially.
 * 
 * We call the helper function passing the left and right to the root. We are
 * doing Inorder traversal.
 * If the left and right value are not equal it sets flag to false and return
 * the result.
 * If both left and right root are null we return to previous recursive stack.
 * if one of them is null, we return false.
 */
class Solution {
    boolean flag;

    public boolean isSymmetric(TreeNode root) {
        flag = true;
        helper(root.left, root.right);

        return flag;
    }

    private void helper(TreeNode rootLeft, TreeNode rootRight) {
        // base
        if (rootLeft == null && rootRight == null)
            return;

        if (rootLeft == null || rootRight == null) {
            flag = false;
            return;
        }

        // logic
        if (flag) {
            helper(rootLeft.left, rootRight.right);
        }
        if (rootLeft.val != rootRight.val) {
            flag = false;
        }
        if (flag) {
            helper(rootLeft.right, rootRight.left);
        }

    }
}