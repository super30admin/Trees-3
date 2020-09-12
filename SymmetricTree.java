/* https://leetcode.com/problems/symmetric-tree/
101. Symmetric Tree - EASY
*/

// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Assume there's a line cutting thru the centre of the tree. 
// The tree is symmetric if the nodes on the left is a mirror image of the nodes on the right.
// WE need to compare nodes - left of left child & right of right child; and right of left child and left of right child

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricHelp(root.left, root.right);
    }

    private boolean isSymmetricHelp(TreeNode left, TreeNode right) {
        if (left == null || right == null)
            return left == right;
        if (left.val != right.val)
            return false;
        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    }
}