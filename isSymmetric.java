// Time Complexity : O(n), where n is the number of nodes in the tree
// Space Complexity : O(h), where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * 1. Check recursively if the left and right subtrees are symmetric.
 * 2. left subtree's left child should be equal to right subtree's right child and 
 *  left subtree's right child should be equal to right subtree's left child and 
 *  left subtree's value should be equal to right subtree's value.
 * 3. If any of the above conditions fail, return false.
 */

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }

        if(left == null || right == null){
            return false;
        }

        return (left.val == right.val) && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}