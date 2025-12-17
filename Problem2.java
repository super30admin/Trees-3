// Time Complexity : O(N) N is the number of nodes
// Space Complexity :O(h) + O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Recursively compare the tree with itself to check for mirror symmetry.
At each step, values must match and left of one side must mirror right of the other.
If all mirrored pairs satisfy this, the tree is symmetric.
*/

import javax.swing.tree.TreeNode;

public class Problem2 {
    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        }

        if(left == null || right == null) {
            return false;
        }

        if(left.val != right.val) {
            return false;
        }

        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
