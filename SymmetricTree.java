// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//DFS
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
    }
    private boolean dfs(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null || left.val != right.val) return false;
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}

//BFS
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while(!q.isEmpty()) {
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            // if left and right are null, no child to explore and add to the queue
            // so proceed to next batch in the queue
            if(left == null & right == null) continue;
            if(left == null || right == null || left.val != right.val) return false;
            //exploring symmetrical nodes together
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }
        return true;
    }

}
