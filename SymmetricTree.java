// Time Complexity : O(N) where N is the number of nodes of the smaller subtree
// Space Complexity : O(H=N) height of the smaller subtree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Recursive solution - DFS
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return helper(root.left, root.right);
    }
    
    private boolean helper(TreeNode root1, TreeNode root2){
        //base
        if(root1 == null && root2 == null)
            return true;
        
        else if(root1 == null || root2 == null)
            return false;
            
        else if(root1.val != root2.val)
            return false;
        //logic
        else{
            boolean case1 = helper(root1.left, root2.right);
            boolean case2 = helper(root1.right, root2.left);
            return case1&&case2;
        }
        
    }
    
}

// Iterative solution - BFS

class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q1 = new LinkedList<>();
        q1.add(root.left);
        q1.add(root.right);
        while(!q1.isEmpty()){
            TreeNode n1 = q1.poll();
            TreeNode n2 = q1.poll();
            
            if(n1 == null && n2 == null)
                continue;
            if(n1 == null || n2 == null)
                return false;
            if(n1.val != n2.val)
                return false;
            
            q1.add(n1.left);
            
            q1.add(n2.right);
           
            q1.add(n1.right);
            
            q1.add(n2.left);
        }
        return true;
    }
}
