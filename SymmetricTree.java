// Time Complexity: O(number fo nodes)
// Space Complexity: O(Height of a tree)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

public class SymmetricTree {
    // Time Complexity: O(number fo nodes)
    // Space Complexity: O(Height of a tree)
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        // start comparing left and right of a tree
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right){
        // if both are null return true, they are symmetric
        if(left == null && right == null){
            return true;
        }
        // if any is null, then return false
        if(left == null || right == null){
            return false;
        }
        // now check for its values as they are not null and other nodes
        return (left.val == right.val) && helper(left.right, right.left) && helper(left.left, right.right);
    }
}
