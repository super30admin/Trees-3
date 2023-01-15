// 101. Symmetric Tree
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approch
// when one node is null & other one is not null or both the root's left & root's right value is not equal, tree is not symmetric.
// To maintain the symmetry, the left of left & right of right node should be equal. Also left of right & right of left node should be equal. So we check those recursively using DFS.


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

//DFS with boolean
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;

        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        //base
        if(left == null && right == null)
            return true;
        //logic
        if(left == null || right == null || left.val != right.val) {
            return false;
        }
        if(dfs(left.left, right.right) == false)
            return false;

        return(dfs(left.right, right.left));
    }
}


// BFS
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
        return true;
        if(root.left == null && root.right == null)
        return true;

        Queue<TreeNode> q = new LinkedList<>();
        //adding from both side & checking at the same time & then remove
        q.add(root.left);
        q.add(root.right);
        while(!q.isEmpty()) {
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if(left == null && right == null) continue;
            if(left == null || right == null || left.val != right.val)
            return false;
            q.add(left.left); q.add(right.right);
            q.add(left.right); q.add(right.left);
        }
        return true;
    }
}