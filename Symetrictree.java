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

//Time Complexity=O(n) where is n is depth of tree
//Space-O(1)
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
        {
            return true;
        }
        return recur(root.left,root.right);
    }
    
    public boolean recur(TreeNode rootleft,TreeNode rootright)
    {
        if(rootleft==null && rootright==null)
        {
            return true;
        }
        if(rootleft==null|| rootright==null|| rootleft.val!=rootright.val)
        {
            return false;
        }
        return recur(rootleft.left ,rootright.right) && recur(rootright.left,rootleft.right);
    }

}