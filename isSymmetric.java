// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
// we use BFS using queue to check symmetry by pushing alternating nodes
class Solution {
    public boolean isSymmetric(TreeNode root) {
        
        if(root==null || (root.left==null && root.right==null) ) return true;
        
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        q.add(root);
        
        while(!q.isEmpty()) {
            
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            
            if(left==null&&right==null) continue;
            if(left==null || right==null) return false;
            if(left.val != right.val) return false;
            
            q.add(left.left);
            q.add(right.right);
            
            q.add(left.right);
            q.add(right.left);
            
        }
        
        return true;
    }
}
