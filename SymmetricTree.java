// Time Complexity : O(n/2) = O(n); Moving through 2 nodes at once
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// For a tree to be symmetric, it's left and right nodes need to be symmetric
// which means; the left and right node values should be equal and the left subtree of the
// left node should be symmetric with right subtree of the right node and vice versa.

import java.util.Stack;

class SymmetricTree {
    public boolean isSymmetricRecursiveSolution(TreeNode root) {
        if (root == null) {
            return false;
        }
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        // if one is null
        if (node1 == null || node2 == null) {
            return false;
        }

        if (node1.val != node2.val) {
            return false;
        }

        return isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);
    }

    public boolean isSymmetricIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root.left);
        stack.push(root.right);

        // DFS using stack
        while (!stack.empty()) {
            // pop top two elements
            TreeNode node1 = stack.pop();
            TreeNode node2 = stack.pop();

            if (node1 == null & node2 == null) {
                continue;
            }

            if (node1 == null || node2 == null) {
                return false;
            }

            if (node1.val != node2.val) {
                return false;
            }

            // push left and right of node 1 and node 2 to check if they are symmetric
            stack.push(node1.left);
            stack.push(node2.right);

            stack.push(node1.right);
            stack.push(node2.left);
        }

        return true;
    }
}