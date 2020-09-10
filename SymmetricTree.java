// Time Complexity : o(n) number of nodes in the tree
// Space Complexity : o(h) height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        //call to the helper function by calling two nodes for comparison
        return isMirror(root, root);
        
    }
    
    public boolean isMirror(TreeNode t1, TreeNode t2){
        //if both nodes are null,  we have reached the end and we can return false
        if(t1==null && t2==null){
            return true;
        }
        //if one node is null and the other node is not null, then we dont have symmetry
        if(t1==null || t2 == null){
            return false;
        }
        //the outer nodes should be the same and the iner nodes should be the same 
        return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
            
        
    }
}