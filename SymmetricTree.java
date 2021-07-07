// Time Complexity : O(n)
// Space Complexity with stack: O(m +n) n : maxDepth
// Space Complexity without stack: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return recur(root.left, root.right);
    }

    private boolean recur(TreeNode leftc, TreeNode rightc){
        if(leftc == null && rightc == null){
            return true;
        }

        if(leftc == null || rightc == null || leftc.val != rightc.val){
            return false;
        }

        return recur(leftc.left, rightc.right) && recur(leftc.right, rightc.left);
    }
}
