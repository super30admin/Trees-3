// Time Complexity : O(N)  N number of nodes.
// Space Complexity : O(h) h is height of the node.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// To check if tree is symmetric, its left node value must be equal to right node value. Also, the same should hold true
// for its right and left child. So we first check if the rule holds true for the current node and then its children as well,
// by calling the same method recursively on its left and right child.
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        return isSymmetricTree(root.left, root.right);
    }


    private boolean isSymmetricTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null)
            return false;

        if (q.val == p.val) {
            return isSymmetricTree(p.left, q.right) && isSymmetricTree(q.left, p.right);
        }

        return false;
    }
}
