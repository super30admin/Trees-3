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
 //Travel all nodes.
 //At every node check left node val and right node val.
 //Call helper using left's left - right'right ; left'r right - right's left
 //TC:O(n);SC:(h)
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return helper(root,root);
        
    }

    private boolean helper(TreeNode left,TreeNode right){
        if(left==null && right==null){
            return true;
        }

       if(left==null && right!=null || (right==null && left!=null)){
        return false;
       }

        if(left.val!=right.val){
            return false;
        }

        return helper(left.left,right.right) && helper(left.right,right.left);
    }
}
