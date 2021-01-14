// Time Complexity : O(n)
// Space Complexity : O(h), h = height of the tree, space used in the recursive stack, under the hood
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Recurse to the left and right node of the tree, while checking if either the left node or right node is not equal to null and left node equals to the right node.

public class SymmetricTree {
    boolean isValid;
    
    public boolean isSymmetric(TreeNode root) {
        isValid = true;
        if(root == null) return isValid;
        recurse(root.left, root.right);
        return isValid;
    }
    
    private void recurse(TreeNode left, TreeNode right){
        
        if(left == null && right == null){
            return;
        }
        
        if(left == null || right == null || left.val != right.val){
            isValid = false;
            return;
        }
        
        recurse(left.left, right.right);
        recurse(left.right, right.left);
    }
}
