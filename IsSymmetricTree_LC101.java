/**
using dfs - T: O(n), S: O(h) under the hood (recursive stack)

using bfs - T: O(n), S(n/2) -> S(n) max width of the tree
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
        if(root == null)
            return true;
        //return dfs(root.left, root.right);
        return bfs(root);
    }
    
    private boolean dfs(TreeNode left, TreeNode right){
        if(left == null || right == null) return true;
        
        if(left == null || right == null || left.val != right.val)
            return false;
        
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
    
    private boolean bfs(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root.left);
        q.add(root.right);
        
        while(!q.isEmpty()){
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