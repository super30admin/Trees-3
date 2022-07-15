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
// --------------------ITERATIVE-------------------
// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);

        while (!q.isEmpty()) {
            TreeNode currLeft = q.poll();
            TreeNode currRight = q.poll();
            if (currLeft != null && currRight != null && currLeft.val != currRight.val) {
                return false;
            } else if (currLeft == null && currRight == null)
                continue;
            else if (currLeft == null || currRight == null)
                return false;
            q.add(currLeft.left);
            q.add(currRight.right);
            q.add(currLeft.right);
            q.add(currRight.left);
        }
        return true;
    }
}