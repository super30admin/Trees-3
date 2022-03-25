/**
 * Time complexity is O(n)
 * space complexity - O(n) worst case stack size - O(h) average case stack size
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return helper(root.left, root.right);
    }
    
    private boolean helper(TreeNode rootA, TreeNode rootB) {
        if(rootA == null && rootB == null) {
            return true;
        }
        if(rootA == null || rootB == null) {
            return false;
        }
        return rootA.val == rootB.val && helper(rootA.left, rootB.right) && helper(rootA.right, rootB.left);
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