/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 //time complexity: O(n)
 //space complexity: O(n);
 //where n is the number of nodes in tree
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return checkSymmetry(root.left, root.right);
    }
    
    public boolean checkSymmetry(TreeNode node1, TreeNode node2)
    {
        if(node1==null &&node2==null)
            return true;
        if(node1==null || node2== null)
            return false;
        if(node1.val != node2.val)
            return false;
       
        return checkSymmetry(node1.left,node2.right)&&checkSymmetry(node1.right,node2.left);
    }
}