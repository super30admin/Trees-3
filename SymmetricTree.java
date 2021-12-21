// Time Complexity : O(n)
// Space Complexity : O(Height)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

// Approach
// Have tried the recursive approach using dfs
// at every point compared the left tree with right tree

class Solution {
    boolean isValid;

    public boolean isSymmetric(TreeNode root) {
        isValid = true;
        if (root == null)
            return isValid;
        dfs(root.left, root.right);
        return isValid;
    }

    public void dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return;
        if (left == null || right == null || left.val != right.val) {
            isValid = false;
            return;
        }
        dfs(left.left, right.right);
        dfs(left.right, right.left);
    }
}

// Approach
// Have tried the recursive approach using dfs with return type as boolean
// at every point compared the left tree with right tree
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null || left.val != right.val)
            return false;
        return (dfs(left.left, right.right) && dfs(left.right, right.left));
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

// Approach
// Have tried the bfs using queue
// at every point popped the left and right and cheked if they were equal and
// then added their children
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while (!q.isEmpty()) {
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if (left == null && right == null)
                continue;
            if (left == null || right == null || left.val != right.val)
                return false;
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }
        return true;
    }
}