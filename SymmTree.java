// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return checkSymm(root.left, root.right);
    }

    private boolean checkSymm(TreeNode left, TreeNode right) {
        // edge

        if (left == null && right == null)
            return true;
        else if (left == null || right == null)
            return false;
        // logic
        if (left.val != right.val)
            return false;
        return checkSymm(left.left, right.right) && checkSymm(left.right, right.left);
    }
} 