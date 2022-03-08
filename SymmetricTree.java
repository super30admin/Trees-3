// Time Complexity : O(n); visiting all the children
// Space Complexity : O(n); function stack size worst case
// Did this code successfully run on Leetcode : Yes; (https://leetcode.com/submissions/detail/656080289/)
// Any problem you faced while coding this : Yes; Tried using Inorder with list and using palindrome; but 1 test case got failed. (https://leetcode.com/submissions/detail/656019405/); understood for some test case it fails. then later implemented another approach.
// My Notes : Compare the childs left and right inversely.
class Solution {
    ArrayList<Integer> list_ = new ArrayList<>();

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        return checkChildren(root.left, root.right);
    }

    private boolean checkChildren(TreeNode left, TreeNode right) {
        // Check left and right; if reached end then valid symmetric nodes found while traversal
        if (left == null && right == null) {
            return true;
        }

        // If both are not null; either of the one is null or values not same then not symmetric
        if (left == null || right == null || left.val != right.val) {
            return false;
        }

        // Check both children both sides inversely
        return checkChildren(left.left, right.right) && checkChildren(left.right, right.left);
    }
}