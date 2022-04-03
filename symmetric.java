/*
// Time Complexity :O(n) where n is the elements of tree
// Space Complexity : O(h) where h is the height of the tree.
// Did this code successfully run on Leetcode : Yes

*/

public class symmetric {

    public boolean isSymmetric(TreeNode root) {

        return helper(root, root);

    }

    public boolean helper(TreeNode t1, TreeNode t2) {

        // base case
        if (t1 == null && t2 == null) {

            return true;
        }

        // if anyone is null
        if (t1 == null || t2 == null) {

            return false;
        }

        // value is not same

        if (t1.val != t2.val) {

            return false;
        }

        return helper(t1.left, t2.right) && helper(t1.right, t2.left);
    }
}
