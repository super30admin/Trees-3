// Time Complexity : O(N) where N is all the nodes in the tree.
// Space Complexity :  O(1) as we are just using two treenode references.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nope.

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        
        TreeNode leftSub = root.left;
        TreeNode rightSub = root.right;
        
        return checkSymmetry(leftSub, rightSub);
    }
    
    public boolean checkSymmetry(TreeNode leftSub, TreeNode rightSub) {
        if(leftSub == null || rightSub == null) {
            return leftSub == rightSub;
        }
        
        if(leftSub.val != rightSub.val) {
            return false;
        }
        
        return checkSymmetry(leftSub.left, rightSub.right) &&
                checkSymmetry(leftSub.right, rightSub.left);
    }

    /* Definition for a binary tree node.*/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
