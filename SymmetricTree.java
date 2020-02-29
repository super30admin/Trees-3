/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Time Complexity :o(n)
// Space Complexity : worst case o(n) or o(height of tree)
// The recursive solution takes up space on the system stack

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
        	return true;
        }

        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode nodeA, TreeNode nodeB) {
        if(nodeA == null && nodeB == null) {
            return true;
        }

        if(nodeA == null || nodeB == null || nodeA.val != nodeB.val) {
            return false;
        }

        return isSymmetric(nodeA.left, nodeB.right) && isSymmetric(nodeA.right, nodeB.left);
    }
}