class Solution {
    // DFS Solution
    // Time complexity is O(n)
    // Space complexity is (h)
    // This solution is submitted on leetcode with no errors 
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
    private boolean flag;
    public boolean isSymmetric(TreeNode root) {
        flag = true;
        //edge case
        if(root == null) return true;
        dfs(root.left, root.right);
        return flag;
    }
    private void dfs(TreeNode left, TreeNode right){
        // base case
        if(left == null && right == null) return;
        
        // logic
        if(left == null || right == null || left.val!=right.val) {
            flag = false;
            return;
        }
        dfs(left.left, right.right);
        if(flag)
            dfs(left.right, right.left);
    }
}