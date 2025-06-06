// Time Complexity: O(N)

// Space Complexity: O(H)
// → Worst-case: O(N) for skewed trees
// → Average-case: O(log N) for balanced trees


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return checkIsMirror(root.left,root.right);
    }

    private boolean checkIsMirror(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;

        if(left.val != right.val) return false;
        return checkIsMirror(left.left,right.right) && checkIsMirror(left.right,right.left);
    }
}
