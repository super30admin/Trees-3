package com.ds.rani.tree;

import java.util.Stack;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *
 * But the following [1,2,2,null,3,null,3] is not:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 *
 * Follow up: Solve it both recursively and iteratively.
 */
public class SymmetricTree {
    /**
     * TreeNode class
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //Recursive
    /**
     * Check whether tree is symmetric or not
     *
     * @param root root of the tree
     * @return
     */

    //Time Complexity:o(n) where n is number of nodes in tree
    //Space complexity:o(h) height of the tree
    public boolean isSymmetricRecursive(TreeNode root) {
        if (root == null)
            return true;
        return isMirror( root.left, root.right );

    }

    /**
     * Helper method to check whether 2 trees are mirror of each other or not
     * @param left root of left tree
     * @param right root of right tree
     * @return true if left and right tree are mirror of each other
     */
    boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val == right.val && isMirror( left.left, right.right ) && isMirror( left.right, right.left ))
            return true;
        return false;

    }
/*********************************************************************************************************/
    //Iterative
//Time Complexity:o(n) where n is number of nodes in tree
//Space complexity:o(2h)==>o(h) where h is height of the tree
    public boolean isSymmetric(TreeNode root) {
        //Edge case
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        //Assume it as true trees, left tree and right tree
        stack.push(root.left);
        stack.push(root.right);

        while (!stack.empty()) {

            TreeNode right = stack.pop();
            TreeNode left = stack.pop();

            if (right == null && left == null) continue;
            if (right == null || left == null || right.val != left.val)
                return false;

            stack.push(right.left);
            stack.push(left.right);
            stack.push(right.right);
            stack.push(left.left);
        }
        return true;
    }
}
