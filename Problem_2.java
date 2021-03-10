// Time Complexity : O(n), number of nodes of tree
// Space Complexity : O(h), height of the tree
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return symmetricHelper(root.left, root.right);
       
    }
    public boolean symmetricHelper(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null || t1.val != t2.val){
            return false;
        }
        return symmetricHelper(t1.left, t2.right) && symmetricHelper(t1.right, t2.left);
    }
}
