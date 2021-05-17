// Time Complexity :  O(N) as there is traversal of all nodes in tree
// Space Complexity : O(N) for queue with all node worstcase
// Did this code successfully run on Leetcode : Yes

class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
    
        //if(root==null) return true;
        
        Queue<TreeNode> q= new LinkedList<>(); // Use queue to iterate level by level
        q.add(root); // Add root twice to ensure symmetry if only root is present
        q.add(root);
        
        while(!q.isEmpty()){
            
            TreeNode t1= q.poll(); // Pop first two elements
            TreeNode t2=q.poll();
            if(t1==null && t2==null) continue;  // If both are null u continue
            if(t1==null || t2==null) return false; // If any one is null rteurn false
            //if(t1==null && t2==null) continue;
            if(t1.val!=t2.val) return false; // If values are not equal return false;
            q.add(t1.left); // Add left child of left node
            q.add(t2.right); // Add right child of right node
            q.add(t1.right); // Add right child of left node
            q.add(t2.left); // Add left child of right node
            
            
        }
        
        return true;
        
}
}