// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class SymmetricTreeIterative {
    public boolean isSymmetric(TreeNode root) {
        
        if (root == null) return true;
       Queue<TreeNode> q = new LinkedList<>();
    
        q.offer(root.left);
        q.offer(root.right);
        
        while(!q.isEmpty()) {
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            
            if(left ==null && right == null) continue;
            if (left == null || right == null || left.val != right.val) return false;
            q.offer(left.left);
            q.offer(right.right);
            q.offer(left.right);
            q.offer(right.left);
            
        }
        return true;
        
    }
}