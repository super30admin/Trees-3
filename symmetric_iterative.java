// Time Complexity : O(n)
// Space Complexity : O(n/2) At leaf level for a full binary tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public boolean isSymmetric(TreeNode root) {
       
        if(root==null)
            return true;
        
        /* Level order traverse BFS */
        
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        queue.add(root);
        
        while(!queue.isEmpty())
        {
            TreeNode left=queue.poll();
            TreeNode right=queue.poll();
            
            if(left==null && right==null)
                continue;
            
            if(left==null || right==null || left.val!=right.val)
                return false;
            
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
            
        }
        return true;
    }
}