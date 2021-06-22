// Time Complexity : O(n)), 
// Space Complexity : O(1),
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No
package trees3;

public class SymmetricTree {
    boolean res = true;
    public boolean isSymmetric(TreeNode root) {
        helper(root.left, root.right);
        return res;
    }
    public void helper(TreeNode nodeLeft, TreeNode nodeRight){
        if(nodeLeft == null && nodeRight == null) return;
        if(res == false) return;
        if(nodeLeft != null && nodeRight != null && nodeLeft.val == nodeRight.val){
            res = true;
            helper(nodeLeft.left, nodeRight.right);
            helper(nodeLeft.right, nodeRight.left); 
        } 
        else res = false;

    }   
}
