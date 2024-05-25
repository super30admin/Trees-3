// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// BFS
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

            if ((left != null && right != null && left.val == right.val)) {
                q.add(left.left);
                q.add(right.right);
                q.add(left.right);
                q.add(right.left);
            } else if ((left == null && right == null))
                continue;
            else
                return false;
        }
        return true;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// DFS
class Solution {
    boolean res = true;

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        dfs(root.left, root.right);
        return res;
    }

    public void dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return;

        if (left == null || right == null || left.val != right.val)
            res = false;

        if (res)
            dfs(left.left, right.right);
        if (res)
            dfs(left.right, right.left);
    }
}