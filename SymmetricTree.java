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
        if(root==null)
            return true;
        if(root.left ==null && root.right==null)
            return true;
        if(root.left!=null && root.right!=null)
            return check(root.left, root.right);
        else
            return false;
    }
    public boolean check(TreeNode left, TreeNode right){
        if(left== null && right ==null)
            return true;
        if(left==null || right == null)
            return false;
        if(left.val!= right.val)
            return false;
        
            return check(left.left,right.right) && check(left.right,right.left);
    }
}