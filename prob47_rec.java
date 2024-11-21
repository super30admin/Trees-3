// S30 Big N Problem #47 {Easy}
// 101. Symmetric Tree
// Time Complexity :O(n) where n is the number of nodes
// Space Complexity : O(2h)--> O(h){asym} where h is the height of the tree 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :None


// Your code here along with comments explaining your approach
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root ==null) return true;
        else return symmetric(root.left,root.right);
    }
    
    private boolean symmetric(TreeNode r1, TreeNode r2){
        if(r1==null && r2==null) return true;
        else if(r1==null || r2==null || r1.val!=r2.val) return false;
        else return symmetric(r1.left,r2.right) && symmetric(r1.right,r2.left);
    }
}