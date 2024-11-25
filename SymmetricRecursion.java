/*
Time complexity: O(n). Because we traverse the entire input tree once, the total run time is O(n), where n
is the total number of nodes in the tree.

Space complexity: The number of recursive calls is bound by the height of the tree. In the worst case, the
tree is linear and the height is in O(n). Therefore, space complexity due to recursive calls on the stack is
O(n) in the worst case.

Did this code successfully run on Leetcode: Yes
 */

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
class SymmetricRecursion {
    public boolean isSymmetric(TreeNode root) {
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode left, TreeNode right)
    {
        //base case
        if(left == null && right == null) return true;

        if( left == null || right == null) return false;

        //logic
        return (left.val == right.val)
                && helper(left.left, right.right)
                && helper(left.right, right.left);

    }
}
