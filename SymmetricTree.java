/**
Problem: Symmetric Tree
Did it run on leetcode : Yes
Time Complexity : O(n), where n is the number of nodes in the tree
Space Complexity : O(log n), where n is the number of nodes in the tree, or O(h), where h is the height of the tree
 
Approach : Recursion
1. We need to check the left subtree and the right subtree to check if the tree is symmetric
2. We must check if the left child of the left subtree is equal to the right child of the right subtree, and also, the if the right child of the left subtree is equal to the left child of the right subtree
3. This is done recursively. And at any point, we find that the values are different, we conclude that the tree is not symmetric. 
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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return check(root.left, root.right);
    }
    public boolean check(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        }
        if(left == null || right == null || left.val != right.val) {
            return false;
        }
        return check(left.left, right.right) && check(left.right, right.left);
    }
}