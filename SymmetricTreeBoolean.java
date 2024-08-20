import javax.swing.tree.TreeNode;

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

// Time complexity = O(n)
// Space complexity = O(1), if we don't consider the stack space.
// Use the left and right subtree.abstract // go inside the left and right.
// then once you hit null, return to the parent. 
// the left.right and right.left.

class SymmetricTreeBoolean {
    public boolean isSymmetric(TreeNode root) {
        return helper(root.left, root.right);
    }
    
    private boolean helper(TreeNode left, TreeNode right) {
        if(left== null && right == null) {
            return true;
        }
        if((left== null && right!=null) || (left!= null && right==null)) {
            return false;
        }
        if(left.val!=right.val) {
            return false;
        }

        return helper(left.left, right.right) && helper(left.right, right.left);
        
    }
}