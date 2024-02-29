// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * We can process 2 nodes at a time using BFS queue. If any of the node is null,
 * or the values don;t match, return false. Since we are adding nulls as well we'll
 * check if both are null, then continue. Keep adding left.left, right.right, left.right, right.left.
 * We are simply checking the nodes at extremes.
 */


public class Problem2 {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root.left);
        q.add(root.right);

        while(!q.isEmpty()) {
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if(left == null && right == null) continue;

            if(left == null || right == null || left.val != right.val) return false;

            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }

        return true;
    }
}
