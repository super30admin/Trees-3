// Time Complexity : O(n) where n is number of nodes in the input tree
// Space Complexity : O(h) where h is height of the binary tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class SymmetricTree {
    public static void main(String[] args) {
        
    }
}
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        
        return helper(root, root);
    }
    
    private boolean helper(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        // for each subtree: check if left and right's current value is equal
        // and left's right value must be equal to right's left value
        // and left's left value must be equal to right's right value
        return (left.val == right.val) && helper(left.left, right.right) && helper(left.right, right.left);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }  
} 
