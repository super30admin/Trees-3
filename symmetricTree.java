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
// Time Complexity: O(n) as we are traversing all nodes in a success case to verify if left is equal to right
// Space Complexity: O(1) no additional datastructure used
// Did you complete it on leetcode: Yes
// Any problems faced: using the inorder traversal could not understand how to add null to left and right for checking if arrays are same.

// Write your approach here:
// Idea here is to simultaneously recurse through both left and right tree and compare values
// if the left value of left subtree is same as right value of right subtree
// as well as if right value of left subtree same as left value if right subtree
// these are mirror images, if this fails at any point, false is returned
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null || (root.left==null && root.right==null) ||
           isSymmetricHelp(root.left, root.right)) return true;
        return false;
    }
    
    public boolean isSymmetricHelp(TreeNode left, TreeNode right) {
        if(left==null || right==null) return left==right;
        if(left.val!=right.val) {
            return false;
        }
        return isSymmetricHelp(left.left, right.right) &&
            isSymmetricHelp(left.right, right.left);
    }
}