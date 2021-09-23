// Time Complexity : O(n) 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
class SymmetricTree {
    boolean isValid; //declaring global variable to store output
    public boolean isSymmetric(TreeNode root) {
        //null check
        if( root == null ) return true; 
        Queue<TreeNode> q = new LinkedList(); //declaring new queue
        
        q.add(root.left); //adding left child to q
        q.add(root.right); //adding right child to q
        
        while(!q.isEmpty()) { //running till the queue gets empty
            TreeNode left = q.poll(); //first popped element is left
            TreeNode right = q.poll(); //second popped element is right
            if(left == null && right == null) continue; //encountered the last level
            
            //either of them is null or they are not equal
            if(left == null || right == null || left.val != right.val) return false;
            
            //keeping the queue go ahead
            q.add(left.left); q.add(right.right);
            q.add(left.right); q.add(right.left);
            //comparison for symmetry
        }
        return true; //if reached here return true because all false cases are tolerated
    }
    
}