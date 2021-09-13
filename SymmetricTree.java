package Trees3;
// Time Complexity : O(n)
// Space Complexity : O(h) (recursion stack)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

import Trees1.TreeNode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return helper(root.left, root.right);
    }
    private boolean helper(TreeNode leftChild, TreeNode rightChild){
        if(leftChild == null && rightChild == null)
            return true;
        if(leftChild == null || rightChild == null || leftChild.val != rightChild.val)
            return false;
        return (helper(leftChild.left, rightChild.right) &&
                helper(leftChild.right, rightChild.left));
    }
}
