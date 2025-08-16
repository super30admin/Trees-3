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
 // This solution uses recursion check starting from node. We check right node and left node at each level value. We traverse through the same node check with symmetric traversal. Right with left and left with right
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return checkSymmetric(root.left, root.right);
    }

    private boolean checkSymmetric(TreeNode left, TreeNode right) {
        if(left==null && right==null) return true;
        if(left==null || right==null) return false;

        return left.val==right.val && checkSymmetric(left.left, right.right) && checkSymmetric(left.right, right.left);
    }
}
