
// Time Complexity : O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
This program checks whether a binary tree is symmetric around its center.
It does so by comparing the left and right subtrees recursively,
ensuring corresponding nodes have equal values and mirrored structure.
If at any point one side is null while the other isn’t, or values mismatch,
the tree is declared asymmetric. The recursion continues until all corresponding nodes are verified.
The solution runs in O(n) time and uses O(h) space,
where h is the height of the tree due to the recursive call stack.
* */

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return isSymmetric(root.left,root.right);
    }

    private boolean isSymmetric(TreeNode left,TreeNode right)
    {
        if(left==null && right==null) return true;
        if(left==null || right==null) return false;

        if(left.val!=right.val)
            return false;

        return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
