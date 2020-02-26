// Time Complexity : O(N) all tree nodes are visisted
// Space Complexity : O(N) height of tree in worst case will be N
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I knew the solution from beforehand.


// Your code here along with comments explaining your approach
//Symmteric tree is a mirror tree, where right side of one tree is equivalent to left side of the other.
//Used recursion.


class Solution {
    public boolean isSymmetric(TreeNode root) {        
        return isMirror(root,root);
    }
    
    private boolean isMirror(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        return isMirror(p.left, q.right) && isMirror(p.right, q.left);
    }
}