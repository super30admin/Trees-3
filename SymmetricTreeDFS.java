// Time Complexity: O(n), where n is the number of nodes in the binary tree.
// Space Complexity: O(h), where h is the height of the tree — for the recursion stack.
// Successfully ran on LeetCode: Yes
// Any issues while implementing: No

// Approach:
// DFS approach using boolean return type
// - Use a recursive helper function that takes two nodes (left and right) and checks:
//   - If both are null, continue (they're symmetric). (both are leaves).
//   - If only one is null or their values differ, the tree is not symmetric — return false.
//   - Recursively compare:
//     - left.left with right.right (outside pair)
//     - left.right with right.left (inside pair)
// - If all mirrored node pairs match recursively, the tree is symmetric, return true.


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
        if(root == null) return true;
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {

        //If both are null, continue (they're still symmetric). (both are leaves).
        if(left == null && right == null) return true;
        //If only one of them is null then they are not symmetric,
        if(left == null || right == null) return false;
        //Else check their values, if not same then they are not symmetric
        if(left.val != right.val)return false;
        //Recurse
        return helper(left.left,right.right) && helper(left.right,right.left);
    }
}