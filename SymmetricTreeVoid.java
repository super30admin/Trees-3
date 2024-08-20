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

class SymmetricTreeVoid {
    boolean flag = true;
    public boolean isSymmetric(TreeNode root) {
        helper(root.left, root.right);
        return flag;
    }
    
    private void helper(TreeNode left, TreeNode right) {
        if(left== null && right == null) {
            return;
        }
        if((left== null && right!=null) || (left!= null && right==null)) {
            flag = false;
            return;
        }
        if(left.val!=right.val) {
            flag = false;
        }

        helper(left.left, right.right);
        // stack.pop() happens here. return to the parent.
        helper(left.right, right.left);
        return;
    }
}