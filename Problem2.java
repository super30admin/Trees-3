/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
LeetCode Submitted : YES
Space Complexity : O(1) //Not counting recursion stack
Time Complexity : O(N^2)
The idea is to check left and right subtree. Comparing left-> left with right-> right and left-> right with right-> left
**/

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        
        return find(root.left, root.right);
    }
    
    private boolean find(TreeNode left, TreeNode right){
        if(left == null && right == null)
            return true;
        
        if(left == null || right == null || left.val != right.val)
            return false;
        
        return find(left.left, right.right) && find(left.right,right.left);
        
    }
}
