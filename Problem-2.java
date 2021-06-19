// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// if both nodes are null return true as the are equal
// if either node is null then they are not equal return false
// then check if values are same in both nodes
// then we recursively check left with right and right with left at each node of the tree
class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }

    private boolean helper(TreeNode node1, TreeNode node2) {
        // base
        if (node1 == null && node2 == null)
            return true;

        // logic
        if (node1 == null || node2 == null)
            return false;

        return node1.val == node2.val && helper(node1.left, node2.right) && helper(node1.right, node2.left);
    }
}