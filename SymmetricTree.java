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

/*
    Leetcode problem 101: Symmetric Tree 
    T.C: O(n) :: S.C: O(h) - height of the recursive stack

    Solved using DFS iteration: We can write a boolean method that returns
    true if both leftNode and rightNode of the root is null (This would serve
    as our base case for the recursive method). Then we can go recursively to
    the depth of the tree (for leftNode and rightNode) and check if the leftNodes 
    value is equal to the rightNodes value. Return false if the condition fails or
    if one of them is null. Else we just return the base case's true condition.
*/

class Solution {
    //boolean isValid = true;

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return dfs(root.left, root.right);

        //return isValid;
    }

    private boolean dfs(TreeNode leftNode, TreeNode rightNode) {
        //Base case
        if (leftNode == null && rightNode == null) return true;

        if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
            //isValid = false;
            return false;
        }
        //Logic - Recursively go to the depth of the tree
        return dfs(leftNode.left, rightNode.right) && dfs(leftNode.right, rightNode.left);
    }
}