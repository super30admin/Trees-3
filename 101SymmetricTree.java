// Problem: https://leetcode.com/problems/symmetric-tree/
// Time Complexity : O(n)
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach : I have used DFS
// approach to solve this problem. I have checked if the left and right child of
// the current node are equal or not. If not, then I have returned false. If
// yes, then I have recursively called the left child of the left child and
// right child of the right child and vice versa. I have kept a flag to keep
// track of the symmetry of the tree.

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
        if(root==null){
            return true;
        }
        return checkSymmetry(root.left,root.right);
    }
       

    public boolean checkSymmetry(TreeNode leftSubTree, TreeNode rightSubTree){
        if(leftSubTree==null && rightSubTree==null){
            return true;
        }
        if(leftSubTree!=null && rightSubTree!=null){
            return leftSubTree.val == rightSubTree.val &&
        checkSymmetry(leftSubTree.right, rightSubTree.left) && 
        checkSymmetry(leftSubTree.left, rightSubTree.right);
        }

        return false;

    }

}
