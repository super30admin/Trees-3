//Time Complexity: O(n)
//Space Complexity: O(h)  where h is the height of the tree

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
    public boolean isSymmetric(TreeNode root) {
        return helper(root.left, root.right);
    }

    public static boolean helper (TreeNode node, TreeNode node2){
        if(node==null && node2==null)
            return true;
        if(node==null || node2==null)
            return false;
        return node.val == node2.val && helper(node.left, node2.right) && helper(node.right, node2.left);
    }
}