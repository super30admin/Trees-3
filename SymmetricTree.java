//Time Complexity : O(n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No


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
 /*
 we recursilevly check left and right subtree. We name them as 2 roots. For tree to be symmetric, left subtree left child
 should be equal right subtree right node, and, left subtree right child
 should be equal right subtree left node.
 */
class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return helper(root,root);
    }

    private boolean helper(TreeNode root1, TreeNode root2){
        //base
        
        if(root1==null && root2==null){
            return true;
        }else if(root1==null || root2==null){
            return false;
        }
        //logic
        if(root1.val==root2.val){
            return helper(root1.left,root2.right) && helper(root1.right,root2.left);

        }else{
            return false;
        }

    }
}
