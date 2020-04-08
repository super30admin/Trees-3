
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
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
        
            if(root == null){
                return true;
            }
             TreeNode leftNode = root.left;
             TreeNode rightNode = root.right;
            return isMirror(leftNode, rightNode);
        
    }
    
    public boolean isMirror(TreeNode node1, TreeNode node2){
        if(node1==null && node2 == null) return true;
        
        if(node1==null || node2 == null) return false;
        
        return (node1.val==node2.val)
            && isMirror(node1.left, node2.right) 
            && isMirror(node1.right, node2.left);
    }
}