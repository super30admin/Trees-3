// Time Complexity :O(n)
// Space Complexity :O(h) where h is the height of the tree
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :
// Confusion the traversal order to be used for left and right subtree. 
// I was using the same order for both the subtrees which was giving wrong answer. 
// After understanding the traversal order, I was able to solve the problem.

// Your code here along with comments explaining your approach
// We will be doing a pre-order traversal for both the left and right subtree.
// For left subtree, we will be traversing in the order of root->left->right
// For right subtree, we will be traversing in the order of root->right->left   
// We will be comparing the values of the nodes at each level. 
// If they are not same, we will return false.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    boolean res;

    public boolean isSymmetric(TreeNode root) {

        res = true;
        helper(root.left, root.right);
        return res;
    }

    private void helper(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return;
        }
        else if (left == null || right == null || left.val != right.val) {
            res = false;
            return;
        }

        helper(left.left, right.right);
        helper(left.right, right.left);
    }
}