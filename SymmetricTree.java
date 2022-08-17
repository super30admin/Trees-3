// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * BFS approach
 */

class Solution {
    public boolean isSymmetric(TreeNode root) {
        
        if (root == null) return true;
        
        Queue<TreeNode> q = new LinkedList<>();
        
        // add the root.left and root.right to the queue
        q.add(root.left);
        q.add(root.right);
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            for (int i=0;i<size/2;i++) {
                TreeNode first = q.poll();
                TreeNode second = q.poll();
                
                if (first == null && second == null) {
                    continue;
                }
                
                if (first == null || second == null || (first.val != second.val)) {
                    return false;
                }
                
                q.add(first.left);
                q.add(second.right);
                
                q.add(first.right);
                q.add(second.left);
            }
        }
        
        return true;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/**
 * DFS approach
 * We put both the left and right subtree and compare left.left with right.right and left.right with right.left
 */

class Solution {
    
    boolean isSymmetrical;
    
    public boolean isSymmetric(TreeNode root) {
        isSymmetrical = true;
        
        helper(root.left, root.right);
        
        return isSymmetrical;
    }
    
    private void helper(TreeNode left, TreeNode right) {
        
        // Base cases
        if (left == null && right == null) return;
        
        if (left == null || right == null || (left.val != right.val)) {
            isSymmetrical = false;
            return;
        }
        
        // Logic
        helper(left.left, right.right);
        helper(left.right, right.left);
    }
}
