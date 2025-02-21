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
    boolean flag;
    public boolean isSymmetric(TreeNode root) {
        flag=true;
        checkSymmetry(root.left,root.right);
        return flag;
    }

    private void checkSymmetry(TreeNode left, TreeNode right){
        if(left==null && right==null){
            return;
        }
        if(left==null || right==null ||left.val != right.val){
            flag=false;
            return;
        }
        checkSymmetry(left.left,right.right);
        checkSymmetry(left.right,right.left);
    }
}

//TC - O(N) //Traversing through the entire tree
//TC - O(N) //Recursion stack