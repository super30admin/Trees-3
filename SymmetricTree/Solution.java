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

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
/**
 *  Boolean based recursion with DFS
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {

        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {

        if(left == null && right == null) return true;
        if(left == null || right == null) return false;

        if(left.val != right.val) return false;

        if(!dfs(left.left, right.right)) return false;
        return dfs(left.right, right.left);
    }
}

/**
 * DFS
 */
/*
class Solution {

    boolean flag;
    public boolean isSymmetric(TreeNode root) {

        this.flag = true;

        dfs(root.left, root.right);

        return flag;
    }

    private void dfs(TreeNode left, TreeNode right) {

        if(left == null && right == null) return;
        if(left == null || right == null) {
            flag = false;
            return;
        }

        if(left.val != right.val) {
            flag = false;
            return;
        }

        if(flag)
            dfs(left.left, right.right);

        if(flag)
            dfs(left.right, right.left);
    }
}*/

/**
 * BFS
 */
// Time Complexity : O(n)
// Space Complexity : O(n)
/*class Solution {
    public boolean isSymmetric(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);

        while(!q.isEmpty()) {
            TreeNode node1 = q.poll();
            TreeNode node2 = q.poll();

            if(node1 == null && node2 == null) continue;
            if(node1 == null || node2 == null) return false;

            if(node1.val != node2.val) return false;

            q.add(node1.left);
            q.add(node2.right);
            q.add(node1.right);
            q.add(node2.left);
        }

        return true;
    }
}*/
