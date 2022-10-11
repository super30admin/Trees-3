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
// TC : O(n)
// SC : O(h)
// DFS
class Solution {
    private boolean check(TreeNode left, TreeNode right) {
        
        if(left == null && right == null)
            return true;
        
        if(left == null || right == null || left.val != right.val)
            return false;
        
        return check(left.left, right.right) && 
        check(left.right, right.left);
        
    }
    public boolean isSymmetric(TreeNode root) {        
        
        if(root == null) return true;
        
        return check(root.left, root.right);
    }
}

// TC : O(n)
// SC : O(n)
// BFS

class Solution {
    
    public boolean isSymmetric(TreeNode root) {        
        
        if(root == null) return true;
        
        Queue<TreeNode> q = new LinkedList<>();
        
        if((root.left == null && root.right != null)
          || root.right == null && root.left != null)
            return false;
        
        if(root.left == null && root.right == null)
            return true;
        
                q.add(root.left);
                q.add(root.right);

        TreeNode left, right;
        while(!q.isEmpty()) {
            
            left = q.poll();
            right = q.poll();
            
            if((left.left == null && right.right != null) 
              || (right.right == null && left.left != null)
              || (left.right == null && right.left != null)
              || (left.right != null && right.left == null))
                return false;
            
            if(left.val != right.val)
                return false;
            
            if(left.left != null && right.right != null) {
                q.add(left.left);
                q.add(right.right);
            }
            
            if(left.right != null && right.left != null) {
                q.add(left.right);
                q.add(right.left);
            }

        }
        
        return true;
        
    }
}
