// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        // // BFS, TC = O(N), SC = O(N)
        // Queue<TreeNode> q = new LinkedList<>();
        // q.add(root.left);
        // q.add(root.right);
        // while(!q.isEmpty()) {
        //     TreeNode left = q.poll();
        //     TreeNode right = q.poll();
        //if(left == null && right == null) continue;//dnt return as we have to check for other subtrees
        //     if(left == null || right == null || left.val != right.val) return false;
        ////putting in order of checking left's left with right's right & left's right with right's left
        //     q.add(left.left); q.add(right.right);
        //     q.add(left.right); q.add(right.left);
        // }
        // return true;

        // DFS, TC = O(N), SC = O(H)
        return dfs(root.left, root.right); // checking in pairs
    }
    private boolean dfs(TreeNode left, TreeNode right) {
        // base
        if(left == null && right == null) return true;
        // logic
        if(left == null || right == null || left.val != right.val) return false;
        // putting in order of checking left's left with right's right & left's right with right's left
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}