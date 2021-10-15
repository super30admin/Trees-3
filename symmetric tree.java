//Time complexity:- o(n).
//space complexity:-0(1).
//Did the code run successfully on leetcode:- yes
//what problems did you face?:- initially got some cases wrong and null pointer exceptions.
//Your code with explanation:- for left subtree taking root1 node and right subtree taking root2 node for tree to be symetric 
// left child of left parent must be right child of right parent and vice versa based on this condition finally calling recurrsion with parameters
// exchanged.

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
        return solve(root, root);
    }
    
    boolean solve(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.val != root2.val) return false;
        return solve(root1.left, root2.right) && solve(root1.right, root2.left);
    }
}