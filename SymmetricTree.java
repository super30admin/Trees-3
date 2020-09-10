// Time Complexity : O(n)
// Space Complexity : O(1) without including rec stack, else O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//we shall consider left and right subtrees separately
//see at each node, if left of left subtree and right of right subtree, right of left subtree and left of right subtree are equal
//and go on recursively till last
//at any point if it isnt equal, return false.

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) {return true;}
        return recurr(root.left, root.right);
    }
    
    private boolean recurr(TreeNode p1Left, TreeNode p2Right){
        if(p1Left==null && p2Right==null) {return true; }
        if(p1Left==null||p2Right==null||p1Left.val!=p2Right.val){ return false;}
        return recurr(p1Left.left,p2Right.right) &&recurr(p1Left.right,p2Right.left);
    }
}