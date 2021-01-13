// Time Complexity : The time complexity is O(n) where n is the number of tree nodes.
// Space Complexity : The space complexity is O(h) where h is the height of the tree.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
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

        if(root == null){
            return true;
        }

        return traverseTree(root.left,root.right);

    }

    // Maintain two pointers, one for the left part and other for the right part
    public boolean traverseTree(TreeNode leftNode,TreeNode rightNode){

        if(leftNode == null && rightNode == null){
            return true;
        }

        if(leftNode == null || rightNode == null){
            return false;
        }

        if(leftNode.val != rightNode.val){
            return false;
        }

        return (traverseTree(leftNode.left,rightNode.right) && traverseTree(leftNode.right,rightNode.left));
    }
}