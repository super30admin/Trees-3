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
 // tIme complexity - O(n)
 // Space somplexity- O(h) - recursive stack size
 // Did you solve on leetcode- yes
 // Faced any issues - No
 // here we are checking if a binary tree is symmetric by comparing the left and right subtrees recursively. It compares the values of mirrored nodes (left with right and vice versa) and ensures their structure and values match. If all corresponding mirrored pairs are equal throughout the tree, it returns true; otherwise, it returns false.
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode left, TreeNode right) {
        if(left == null || right == null) {
            return left == right;
        } if(left.val!= right.val) return false;
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
