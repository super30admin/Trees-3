// TC : O(n)
// SC : O(h) ... worst O(n)
// Ran on LC : Yes
// Problems : None.

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
    boolean flag;
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        flag = true;
        
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
        
        // dfs(root.left, root.right);
        return flag;
    }
    
    private void dfs(TreeNode left, TreeNode right) {
        //base
        if(left == null && right == null) return;
        
        if(left == null || right == null || left.val != right.val) {
            flag = false;
            return;
        }
        
        //logic
        if(flag)
            dfs(left.left, right.right);
        
        if(flag)
            dfs(left.right, right.left);
    }
}